package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class AccountCreatedPage extends MethodHandles {
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    //Methods
    public HomePage clickOnContinueButton()
    {
        click(continueButton,5);
        return new HomePage(driver);
    }
}
