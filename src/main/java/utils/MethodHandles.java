package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver ;
    WebDriverWait wait;
    Select select;
    JavascriptExecutor js;


    //Constructor
    public MethodHandles(WebDriver driver)
    {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }

    //Methods
    private WebElement webElement(By locator)
    {
        return driver.findElement(locator);
    }
    private void explicitWait(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(webElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }
    protected void click(By locator ,int time)
    {
        explicitWait(locator,time);
        webElement(locator).click();
    }
    protected void sendKeys(By locator, int time ,String text)
    {
        explicitWait(locator,time);
        webElement(locator).sendKeys(text);
    }
    protected void selectByIndex(By locator , int index ,int time)
    {
        explicitWait(locator,time);
        select =new Select(webElement(locator));
        select.selectByIndex(index);
    }

   protected void selectByValue(By locator , String value ,int time)
    {
        explicitWait(locator,time);
        select =new Select(webElement(locator));
        select.selectByValue(value);
    }
    protected void selectByVisibleText(By locator , String text ,int time)
    {
        explicitWait(locator,time);
        select =new Select(webElement(locator));
        select.selectByVisibleText(text);
    }
    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    protected String getText(By locator , int time)
    {
        explicitWait(locator,time);
        return webElement(locator).getText();

    }
}
