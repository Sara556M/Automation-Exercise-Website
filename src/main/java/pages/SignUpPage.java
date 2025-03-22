package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.MethodHandles;

public class SignUpPage extends MethodHandles {
    Select select;
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By mrsRadioButton = By.xpath("//input[@value=\"Mrs\"]");
    private final By password = By.xpath("//input[@type=\"password\"]");
    private final By daysSelect = By.xpath("//select[@data-qa=\"days\"]");
    private final By monthsSelect = By.xpath("//select[@data-qa=\"months\"]");
    private final By yearSelect = By.xpath("//select[@data-qa=\"years\"]");
    private final By newsLetter =By.xpath("//input[@name=\"newsletter\"]");
    private final By specialOffers = By.xpath("//input[@name=\"optin\"]");
    private final By firstName = By.xpath("//input[@data-qa=\"first_name\"]");
    private final By lastName = By.xpath("//input[@data-qa=\"last_name\"]");
    private final By company = By.xpath("//input[@data-qa=\"company\"]");
    private final By address = By.xpath("//input[@data-qa=\"address\"]");
    private final By countrySelect = By.xpath("//select[@data-qa=\"country\"]");
    private final By state = By.xpath("//input[@data-qa=\"state\"]");
    private final By city = By.xpath("//input[@data-qa=\"city\"]");
    private final By zipCode = By.xpath("//input[@data-qa=\"zipcode\"]");
    private final By mobileNumber = By.xpath("//input[@data-qa=\"mobile_number\"]");
    private final By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    //Method
    public void clickOnMrs( )
    {
        click(mrsRadioButton,5);
    }
    public void insertPassword(String pass)
    {
        sendKeys(password,5,pass);
    }
    public void selectDay(String value)
    {
        selectByValue(daysSelect,value,5);
    }
    public void selectMonth(String value)
    {
        selectByValue(monthsSelect,value,5);
    }
    public void selectYear(String value)
    {
        selectByValue(yearSelect,value,5);
    }
    public void clickOnNewsLetter()
    {
        scrollToElement(newsLetter);
        click(newsLetter,5);
    }
    public void clickOnSpecialOffers()
    {
        scrollToElement(specialOffers);
        click(specialOffers,5);
    }
    public void insertFirstName(String text)
    {
        sendKeys(firstName,5,text);
    }
    public void insertLastName(String text)
    {
        sendKeys(lastName,5,text);
    }
    public void insertCompany(String text)
    {
        sendKeys(company,5,text);
    }
    public void insertAddress(String text)
    {
        sendKeys(address,5,text);
    }
    public void selectCountry(String value)
    {
        selectByValue(countrySelect,value,5);
    }
    public void insertState(String text)
    {
        sendKeys(state,5,text);
    }
    public void insertCity(String text)
    {
        sendKeys(city,5,text);
    }
    public void insertZipCode(String text)
    {
        sendKeys(zipCode,5,text);
    }
    public void insertMobileNumber(String text)
    {
        sendKeys(mobileNumber,5,text);
    }
    public AccountCreatedPage clickOnCreateAccountButton()
    {
        scrollToElement(createAccountButton);
        click(createAccountButton,10);
        return new AccountCreatedPage(driver);
    }

}
