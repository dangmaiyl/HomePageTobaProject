package test;

import constant.Constant;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewPage;
import pages.SEOPage;

public class TestSEO extends BaseTest {
    @Test
    public void Test_Search_SEO(){
            LoginPage loginPage = new LoginPage(getDriver());
            SEOPage seoPage = new SEOPage(getDriver());

            loginPage.navigateToHomePage(Constant.URL);
            loginPage.inputEmail(Constant.EMAIL);
            loginPage.inputPassword(Constant.PASSWORD);
            loginPage.clickLogInButton();
            seoPage.clickSEOButton();
            seoPage.inputSearchBox("duong");
            seoPage.clickSearchButton();
            seoPage.verifyResultSearch("duong");

        }
    @Test
    public void Test_Search_SEO_refresh(){
        LoginPage loginPage = new LoginPage(getDriver());
        SEOPage seoPage = new SEOPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        seoPage.clickSEOButton();
        seoPage.inputSearchBox("duong");
        seoPage.clickRefreshButton();
        seoPage.verifyPlaceHolderSearchBox();

    }
    @Test
    public void Test_Search_SEO_no_data(){
        LoginPage loginPage = new LoginPage(getDriver());
        SEOPage seoPage = new SEOPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        seoPage.clickSEOButton();
        seoPage.inputSearchBox("khong co data");
        seoPage.clickSearchButton();
        seoPage.verifyValidateNoData();

    }

    //Chuc nang tao SEO slug
    @Test
    public void Test_Create_SEO_slug(){
        LoginPage loginPage = new LoginPage(getDriver());
        SEOPage seoPage = new SEOPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        seoPage.clickSEOButton();
        seoPage.clickCreateSEOButton();
        seoPage.inputPath("tao seo slug de test");
        seoPage.clickCreateButton();
        seoPage.verifyResult("seo");

    }
    //Bo trong duong dan
    @Test
    public void Test_Create_SEO_slug_path_null(){
        LoginPage loginPage = new LoginPage(getDriver());
        SEOPage seoPage = new SEOPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        seoPage.clickSEOButton();
        seoPage.clickCreateSEOButton();
        seoPage.clickCreateButton();
        seoPage.verifyValidatePath();
    }
    @Test
    public void Test_Edit_Seo_slug(){
        LoginPage loginPage = new LoginPage(getDriver());
        SEOPage seoPage = new SEOPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        seoPage.clickSEOButton();
        seoPage.clickEditButton();
        seoPage.editPath("face mask high quality ");
        seoPage.clickUpdateButton();
        seoPage.verifyValidateEditPath();
    }

    //Chuc nang xoa  seo slug
    @Test
    public void Test_delete_seo_slug(){
        LoginPage loginPage = new LoginPage(getDriver());
        SEOPage seoPage = new SEOPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        seoPage.clickSEOButton();
        seoPage.clickDeleteSeoSlug();
        seoPage.clickAcceptButton();
        seoPage.verifyValidateDeleteSuccess();
    }
    @Test
    public void Test_delete_seo_slug_cancel(){
        LoginPage loginPage = new LoginPage(getDriver());
        SEOPage seoPage = new SEOPage(getDriver());

        loginPage.navigateToHomePage(Constant.URL);
        loginPage.inputEmail(Constant.EMAIL);
        loginPage.inputPassword(Constant.PASSWORD);
        loginPage.clickLogInButton();
        seoPage.clickSEOButton();
        seoPage.clickDeleteSeoSlug();
        seoPage.clickCancelButton();
    }

}
