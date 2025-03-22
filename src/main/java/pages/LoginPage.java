package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private final By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By password = By.name("password");
    private final By loginButton = By.xpath("//button[contains(text(),\"Login\")]");
    private final By name = By.name("name");
    private final By signUpEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    private final By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    //Methods
    public void insertLoginEmail(String text){
        sendKeys(loginEmail, 10,text);
    }
    public void insertSignUpEmail(String text){
        sendKeys(signUpEmail, 10,text);
    }
    public void insertSignUpName(String text){
        sendKeys(name, 10,text);
    }

    public void insertLoginPassword(String passwordText)
    {
        sendKeys(password,10,passwordText);
    }
    public HomePage clickOnLoginButton()
    {
        click(loginButton,5);
        return new HomePage(driver);
    }
    public SignUpPage clickOnSignUpButton()
    {
        click(signUpButton,5);
        return new SignUpPage(driver);
    }
}
