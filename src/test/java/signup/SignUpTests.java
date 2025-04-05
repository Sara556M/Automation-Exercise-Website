package signup;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileNotFoundException;

import static reader.ReadDataFromJson.dataModel;

public class SignUpTests extends BaseTests {
    String userName;
    String deleteMsg ;

    @DataProvider
    private Object[] InaValidDataToSignUp() throws FileNotFoundException {
        return dataModel().Signup.Email.EmailIsNotValid.Email;
    }
    @Test(dataProvider = "InaValidDataToSignUp")
    public void signUpWithInvalidEmail(String mail) throws FileNotFoundException {

        LoginPage loginPage =homePage.clickOnSignUpAndLoginButton();
        loginPage.insertSignUpEmail(mail);
        //loginPage.insertSignUpName(dataModel().Signup.Name);


    }
    @Test
    public void signUpTest() throws FileNotFoundException {
        LoginPage loginPage =homePage.clickOnSignUpAndLoginButton();
        loginPage.insertSignUpName(dataModel().Signup.Name);
        loginPage.insertSignUpEmail(dataModel().Signup.Email.EmailIsValid.Email);
        SignUpPage signUpPage =loginPage.clickOnSignUpButton();
        signUpPage.clickOnMrs();
        signUpPage.insertPassword(dataModel().Signup.Password);
        signUpPage.selectDay(dataModel().Signup.Day);
        signUpPage.selectMonth(dataModel().Signup.Month);
        signUpPage.selectYear(dataModel().Signup.Year);
        signUpPage.clickOnNewsLetter();
        signUpPage.clickOnSpecialOffers();
        signUpPage.insertFirstName(dataModel().Signup.FirstName);
        signUpPage.insertLastName(dataModel().Signup.LastName);
        signUpPage.insertCompany(dataModel().Signup.Company);
        signUpPage.insertAddress(dataModel().Signup.Address);
        signUpPage.selectCountry(dataModel().Signup.Country);
        signUpPage.insertState(dataModel().Signup.State);
        signUpPage.insertCity(dataModel().Signup.City);
        signUpPage.insertZipCode(dataModel().Signup.Zipcode);
        signUpPage.insertMobileNumber(dataModel().Signup.MobileNumber);
        AccountCreatedPage accountCreatedPage = signUpPage.clickOnCreateAccountButton();
        homePage = accountCreatedPage.clickOnContinueButton();
        userName = homePage.verifyUserName();
        Assert.assertEquals(userName,dataModel().Signup.Name);
        DeleteAccountPage deleteAccountPage = homePage.clickOnDeleteAccountButton();
        deleteMsg = deleteAccountPage.getAccountDeletedText();
        Assert.assertEquals(deleteMsg,dataModel().Signup.AccountDeletedMsg);
        deleteAccountPage.clickOnContinueButton();



    }
}
