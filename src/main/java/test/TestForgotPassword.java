package test;

import constant.Constant;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;

public class TestForgotPassword extends BaseTest {
    @Test
    public void Test_forgot_password(){
        LoginPage loginPage = new LoginPage(getDriver());
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        forgotPasswordPage.clickForgotPassword();
        forgotPasswordPage.inputEmail(Constant.EMAIL);
        forgotPasswordPage.clickAcceptButton();
        forgotPasswordPage.verifySetLinkResetPassword("Đặt lại mật khẩu");
    }
    @Test
    public void Test_forgot_password_when_email_null(){
        LoginPage loginPage = new LoginPage(getDriver());
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        forgotPasswordPage.clickForgotPassword();
        forgotPasswordPage.clickAcceptButton();
        forgotPasswordPage.verifyEmailNull("Bạn cần nhập thông tin này");
    }
    @Test
    public void Test_forgot_password_when_email_invalid(){
        LoginPage loginPage = new LoginPage(getDriver());
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        forgotPasswordPage.clickForgotPassword();
        forgotPasswordPage.inputEmail(Constant.EMAIL_NOT_VALID);
        forgotPasswordPage.clickAcceptButton();
        forgotPasswordPage.verifyEmailInvalid("Vui lòng nhập chính xác địa chỉ email của bạn");
    }
    @Test
    public void Test_forgot_password_when_email_not_register(){
        LoginPage loginPage = new LoginPage(getDriver());
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        forgotPasswordPage.clickForgotPassword();
        forgotPasswordPage.inputEmail(Constant.EMAIL_NOT_REGISTER);
        forgotPasswordPage.clickAcceptButton();
        forgotPasswordPage.verifyValidateEmailNotRegister("Email không hợp lệ");
    }

}
