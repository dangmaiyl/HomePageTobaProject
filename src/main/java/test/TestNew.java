package test;

import constant.Constant;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.NewPage;

public class TestNew extends BaseTest {
    @Test
    public void Test_Search_New(){
        LoginPage loginPage = new LoginPage(getDriver());
        NewPage newPage = new NewPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        newPage.clickNewButton();
        newPage.inputSearchBox("mai");
        newPage.clickSearchButton();
        newPage.verifyNew("mai");
    }
    @Test
    public void Test_Search_No_Data(){
        LoginPage loginPage = new LoginPage(getDriver());
        NewPage newPage = new NewPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        newPage.clickNewButton();
        newPage.inputSearchBox("hihi123hihi456hihi789");
        newPage.clickSearchButton();
        newPage.verifyValidateSearchNoData("Không có dữ liệu");
    }
    @Test
    public void Test_add_New(){
        LoginPage loginPage = new LoginPage(getDriver());
        NewPage newPage = new NewPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        newPage.clickCreateNewButton();
        newPage.uploadPicture("");
    }
}
