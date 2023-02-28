package test;

import constant.Constant;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.FQAPage;
import pages.LoginPage;
import pages.NewPage;

public class TestFQA extends BaseTest {
    @Test
    public void Test_Search(){
        LoginPage loginPage = new LoginPage(getDriver());
        FQAPage fqaPage = new FQAPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        fqaPage.clickFQAButton();
        fqaPage.inputSearchBox("mai");
        fqaPage.clickSearchButton();
        fqaPage.verifyValidateFQA("mai");
    }
    @Test
    public void Test_Search_No_Data(){
        LoginPage loginPage = new LoginPage(getDriver());
        FQAPage fqaPage = new FQAPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        fqaPage.clickFQAButton();
        fqaPage.inputSearchBox("No pain , no gain");
        fqaPage.clickSearchButton();
        fqaPage.verifyValidateNoData("Không có dữ liệu");
    }
    @Test
    public void Test_create_FQA_only_input_title(){
        LoginPage loginPage = new LoginPage(getDriver());
        FQAPage fqaPage = new FQAPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        fqaPage.clickFQAButton();
        fqaPage.clickCreateFQAButton();
        fqaPage.inputTitleFQA("Chi viet beo");
        fqaPage.clickCreateButton();
        fqaPage.verifyValidateContent("Bạn cần nhập thông tin này");
    }
    @Test
    public void Test_create_FQA_only_input_content(){
        LoginPage loginPage = new LoginPage(getDriver());
        FQAPage fqaPage = new FQAPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        fqaPage.clickFQAButton();
        fqaPage.clickCreateFQAButton();
        fqaPage.inputContent();
        fqaPage.clickCreateButton();
        fqaPage.verifyValidateTitle("Bạn cần nhập thông tin này");
    }

}
