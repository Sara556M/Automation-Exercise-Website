package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class HomePage extends MethodHandles {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By signUpAndLogin = By.linkText("Signup / Login");
    private final By loginUser  = By.tagName("b");
    private final By deleteAccountButton = By.xpath("//a[contains(@href, '/delete_account') and contains(text(), 'Delete Account')]");

    //Methods
    public LoginPage clickOnSignUpAndLoginButton()
    {
        click(signUpAndLogin,5);
        return new LoginPage(driver);
    }
    public String verifyUserName()
    {
        return getText(loginUser , 5);
    }
    public DeleteAccountPage clickOnDeleteAccountButton()
    {
        click(deleteAccountButton,5);
        return new DeleteAccountPage(driver);
    }
}
