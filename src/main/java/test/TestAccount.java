package test;

import constant.Constant;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

public class TestAccount extends BaseTest {


    @Test
    public void Test_Account(){
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();

        accountPage.inputSearchBox("mai");
        accountPage.clickSearchButton();
        accountPage.verifyResult("mai");
    }


}
