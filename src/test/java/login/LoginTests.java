package login;

import base.BaseTests;
import data.InvalidCreditials;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.LoginPage;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class LoginTests extends BaseTests {
    String userName;
    String deleteMsg ;

    @Test
    public void loginWithCorrectEmailAndPassword() throws FileNotFoundException {
        LoginPage loginPage =homePage.clickOnSignUpAndLoginButton();
        loginPage.insertLoginEmail(dataModel().Login.ValidCreditials.Email);
        loginPage.insertLoginPassword(dataModel().Login.ValidCreditials.Password);
        homePage=loginPage.clickOnLoginButton();
        userName = homePage.verifyUserName();
        Assert.assertEquals(userName,dataModel().Login.ValidCreditials.UserName);
        DeleteAccountPage deleteAccountPage =homePage.clickOnDeleteAccountButton();
        deleteMsg = deleteAccountPage.getAccountDeletedText();
        Assert.assertEquals(deleteMsg,dataModel().Signup.AccountDeletedMsg);

    }



}
