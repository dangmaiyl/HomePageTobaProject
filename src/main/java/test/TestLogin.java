package test;

import constant.Constant;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TestLogin extends BaseTest {
    // Trường hợp đăng nhập thành công
    @Test
    public void Test_Login(){
    LoginPage loginPage = new LoginPage(getDriver());
    loginPage.navigateToHomePage(Constant.URL);
    loginPage.inputEmail(Constant.EMAIL);
    loginPage.inputPassword(Constant.PASSWORD);
    loginPage.clickLogInButton();
    loginPage.verifyHomepage();
}
    //Trường hợp đăng nhập không thành công
    //Sai email
    @Test
    public void Test_Login_with_email_invalid(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL_NOT_VALID);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        loginPage.validateEmailNotValid("Vui lòng nhập chính xác địa chỉ email của bạn");
    }

    //Sai password
    @Test
    public void Test_Login_with_password_invalid(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD_NOT_VALID);
        loginPage.verifyValidatePasswordInValid("Mật Khẩu không hợp lệ");
        loginPage.clickLogInButton();

    }
    //Bo trong email
    @Test
    public void Test_Login_with_email_is_null(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        loginPage.verifyEmailIsNull("Bạn cần nhập thông tin này");
    }
    //Bo trong password
    @Test
    public void Test_Login_with_password_is_null(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.clickLogInButton();
        loginPage.verifyPasswordIsNull("Bạn cần nhập thông tin này");
    }
    //Bo trong email + password
    @Test
    public void Test_Login_with_email_and_password_is_null(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToHomePage(Constant.URL);
        loginPage.clickLogInButton();
        loginPage.verifyEmailAndPassWordNull("Bạn cần nhập thông tin này");
    }
    //Nhap tai khoan chua tao
    @Test
    public void Test_Login_with_account_invalid(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail("test@gmail.com");
        loginPage.inputPassword("12345678");
        loginPage.clickLogInButton();
        loginPage.verifyEmailAndPassWordNull("Email không hợp lệ");
    }

}
