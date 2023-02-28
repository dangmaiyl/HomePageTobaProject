package test;

import constant.Constant;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

public class TestAccount extends BaseTest {

    @Test
    public void Test_Account_Search(){
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
    @Test
    public void Test_Account_Search_when_no_data(){
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();

        accountPage.inputSearchBox("mmmmmmmmmmm");
        accountPage.clickSearchButton();
        accountPage.verifyValidateNoData("Không có dữ liệu");
    }
    @Test
    public void Test_create_account(){
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        accountPage.clickCreateAccountButton();
        accountPage.inputEmail("Test890@gmail.com");
        accountPage.inputFullName("Chi Viet");
        accountPage.inputPassword("123123123a");
        accountPage.inputRePassword("123123123a");
        accountPage.clickCreateButton();
        accountPage.verifyListAccount("Chi Viet");
    }
    @Test
    public void Test_create_account_when_fullName_is_null(){
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        accountPage.clickCreateAccountButton();
        accountPage.inputEmail("Test890@gmail.com");
        accountPage.inputRePassword("123123123a");
        accountPage.clickCreateButton();
        accountPage.verifyValidateFullNameNull("Bạn cần nhập thông tin này");
    }
    @Test
    public void Test_create_account_when_rePassword_is_null(){
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        accountPage.clickCreateAccountButton();
        accountPage.inputEmail("Test890@gmail.com");
        accountPage.inputFullName("Mai");
        accountPage.clickCreateButton();
        accountPage.verifyValidateRePassword("Bạn cần nhập thông tin này");
    }
    @Test
    public void Test_create_account_when_email_invalid(){
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        accountPage.clickCreateAccountButton();
        accountPage.inputEmail("maimai1223");
        accountPage.inputFullName("Mai");
        accountPage.inputPassword("123123123a");
        accountPage.inputRePassword("123123123a");
        accountPage.clickCreateButton();
        accountPage.verifyValidateEmailInvalid("Vui lòng nhập chính xác địa chỉ email của bạn");
    }
    @Test
    public void Test_create_account_when_email_registered(){
        LoginPage loginPage = new LoginPage(getDriver());
        AccountPage accountPage = new AccountPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        accountPage.clickCreateAccountButton();
        accountPage.inputEmail(Constant.EMAIL);
        accountPage.inputFullName("Mai");
        accountPage.inputPassword("123123123a");
        accountPage.inputRePassword("123123123a");
        accountPage.clickCreateButton();
        accountPage.verifyValidateEmailRegistered("Email đã được được đăng ký");
    }

}
