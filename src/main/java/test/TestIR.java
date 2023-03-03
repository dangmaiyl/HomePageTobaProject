package test;

import constant.Constant;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.IRPage;
import pages.LoginPage;
import pages.NewPage;

public class TestIR extends BaseTest {
    //Chuc nang search
    @Test
    public void TestIR() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.inputSearchBox("mai");
        irPage.clickSearchBox();
        irPage.verifyResult("mai");
    }

    //Chuc nang search khong co data
    @Test
    public void TestIR_no_data() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.inputSearchBox("4455222223");
        irPage.clickSearchBox();
        irPage.verifyValidateSearch();
    }

    //Chuc nang tao IR
    @Test
    public void TestIR_create() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickCreateIRButton();
        irPage.uploadPicture();
        irPage.uploadFile();
        irPage.selectTime();
        irPage.inputName("Test Mai");
        irPage.inputContentIR("Hi , my name is Mai");
        irPage.clickCreateButton();
        irPage.verifyvalidateCreateIRSuccess();

    }
    @Test
    public void TestIR_create_picture_null() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickCreateIRButton();
        irPage.uploadFile();
        irPage.selectTime();
        irPage.inputName("Test Mai");
        irPage.inputContentIR("Hi , my name is Mai");
        irPage.clickCreateButton();
        irPage.verifyValidatePicture();
    }
    @Test
    public void TestIR_create_file_null() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickCreateIRButton();
        irPage.uploadPicture();
        irPage.selectTime();
        irPage.inputName("Test Mai");
        irPage.inputContentIR("Hi , my name is Mai");
        irPage.clickCreateButton();
        irPage.verifyValidateFile();
    }
    @Test
    public void TestIR_create_Time_null() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickCreateIRButton();
        irPage.uploadPicture();
        irPage.uploadFile();
        irPage.inputName("Test Mai");
        irPage.inputContentIR("Hi , my name is Mai");
        irPage.clickCreateButton();

    }
    @Test
    public void TestIR_create_name_null() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickCreateIRButton();
        irPage.uploadPicture();
        irPage.uploadFile();
        irPage.selectTime();
        irPage.inputContentIR("Hi , my name is Mai");
        irPage.clickCreateButton();
        irPage.verifyValidateName();
    }
    @Test
    public void TestIR_create_content_null() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickCreateIRButton();
        irPage.uploadPicture();
        irPage.uploadFile();
        irPage.selectTime();
        irPage.inputName("Test Mai");
        irPage.clickCreateButton();
        irPage.verifyValidateContent();
    }
    //Chuc nang edit
    @Test
    public void TestIR_edit() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickEditButton();
        irPage.editPicture();
        irPage.editFile();
        irPage.editSelectTime();
        irPage.ediName("Edit name");
        irPage.editContentIR("hihi");
        irPage.clickUpdateButton();
        irPage.verifyvalidateCreateIRSuccess();

    }
    @Test
    public void TestIR_edit_except_picture() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickEditButton();
        irPage.editFile();
        irPage.editSelectTime();
        irPage.ediName("Edit name");
        irPage.editContentIR("hihi");
        irPage.clickUpdateButton();
        irPage.verifyvalidateCreateIRSuccess();
    }
    @Test
    public void TestIR_edit_except_file() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickEditButton();
        irPage.editPicture();
        irPage.editSelectTime();
        irPage.ediName("Edit name");
        irPage.editContentIR("hihi");
        irPage.clickUpdateButton();
        irPage.verifyvalidateCreateIRSuccess();
    }
    @Test
    public void TestIR_edit_except_time() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickEditButton();
        irPage.editPicture();
        irPage.editFile();
        irPage.ediName("Edit name");
        irPage.editContentIR("hihi");
        irPage.clickUpdateButton();
        irPage.verifyvalidateCreateIRSuccess();
    }
    @Test
    public void TestIR_edit_except_name() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickEditButton();
        irPage.editPicture();
        irPage.editFile();
        irPage.editSelectTime();
        irPage.editContentIR("hihi");
        irPage.clickUpdateButton();
        irPage.verifyvalidateCreateIRSuccess();
    }
    @Test
    public void TestIR_edit_except_content() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickIRButton();
        irPage.clickEditButton();
        irPage.editPicture();
        irPage.editFile();
        irPage.editSelectTime();
        irPage.ediName("Edit name");
        irPage.clickUpdateButton();
        irPage.verifyvalidateCreateIRSuccess();
    }

    //Chuc nang xoa IR
    @Test
    public void TestIR_delete() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickDeleteButton();
        irPage.clickAcceptButton();
        irPage.verifyValidateDeleteIR();
    }
    @Test
    public void TestIR_delete_unSuccess() {
        LoginPage loginPage = new LoginPage(getDriver());
        IRPage irPage = new IRPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        irPage.clickDeleteButton();
        irPage.clickCancelButton();
    }


}

