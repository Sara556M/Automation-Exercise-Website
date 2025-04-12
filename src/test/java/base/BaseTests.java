package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class BaseTests {

    WebDriver driver;
    protected HomePage homePage;
    public ChromeOptions chromeOptions;
    public FirefoxOptions firefoxOptions;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome")String browser)
    {
        setUpBrowser(browser);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @Parameters("browser")
    private void setUpBrowser(String browser)
    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        }
        else if (browser.equalsIgnoreCase("headlessChrome"))
        {
            chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equalsIgnoreCase("headlessFirefox"))
        {
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
    }

    @BeforeMethod
    public void goHome() throws FileNotFoundException {
        driver.get(dataModel().URL);
    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

}
