package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class DeleteAccountPage extends MethodHandles {
    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By accountDeletedText = By.xpath("//b[contains(text(),\"Account Deleted!\")]");
    private final By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    //Methods
    public String getAccountDeletedText ()
    {
        return getText(accountDeletedText,5);
    }
    public HomePage clickOnContinueButton()
    {
        click(continueButton,5);
        return new HomePage(driver);
    }
}
