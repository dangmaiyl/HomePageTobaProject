package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }
    // Màn danh sách tài khoản - Chức năng Search

    @FindBy(id = "search-form_fullTextSearch")
    private WebElement searchBoxAccount ;
    @FindBy(xpath = "//button[@class=\"ant-btn ant-btn-default\"]/span[contains(text(),'Tìm kiếm')]")
    private WebElement searchButton;
    @FindBy(xpath = "//button[@class=\"ant-btn ant-btn-default\"]/span[contains(text(),'Làm mới')]")
    private WebElement refreshButton;

    private String listResult = "//td/span[contains(text(),'%s')]";


    public void inputSearchBox(String value){
      senKeyElementById(searchBoxAccount,value);
    }
    public void clickSearchButton(){
        clickElementByXpath(searchButton);
    }
    public void clickRefreshButton(){
        clickElementByXpath(refreshButton);
    }
    public void verifyResult (String resultAccount){
         Assert.assertTrue(driver.findElement(By.xpath(String.format(listResult,resultAccount))).isDisplayed());
    }
    //Validate khi khi không có data đươc tìm kiếm
    @FindBy(xpath = " //div[contains(text(),'Không có dữ liệu')]")
    private WebElement validateNoData;
    public void verifyValidateNoData(String value){
        Assert.assertEquals(validateNoData.getText(),value);
    }

    // Chức năng tạo account

    @FindBy(xpath = "//button/span[contains(text(),'Tạo tài khoản')]")
    private WebElement createAccountButton;
    public void clickCreateAccountButton(){
        clickElementByXpath(createAccountButton);
    }
    @FindBy(id = "create-form_email")
    private WebElement email;
    public void inputEmail(String value){
        email.clear();
        senKeyElementById(email,value);
    }
    @FindBy(id = "create-form_password")
    private WebElement password;
    public void  inputPassword(String value){
        password.clear();
        senKeyElementById(password,value);
    }
    @FindBy(id = "create-form_fullName")
    private WebElement fullName;
    public void inputFullName(String value){
        senKeyElementById(fullName,value);
    }
    @FindBy(id = "create-form_repassword")
    private WebElement rePassword;
    public void inputRePassword(String value){
        senKeyElementById(rePassword,value);
    }
    @FindBy(xpath = "//button/span[contains(text(),'Tạo tài khoản')]")
    private WebElement createButton;
    public void clickCreateButton(){
        clickElementByXpath(createButton);
    }
    private String listAccount = "//div[@class=\"ant-table-content\"]//td//span[contains(text(),'%s')]";
    public void verifyListAccount(String value){
        Assert.assertTrue(getDynamicLocator(String.format(listAccount,value)).isDisplayed());

    }
    //Chức năng tạo account _ Bỏ trống Tên
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[2]/div[2]/div[1]")
    private WebElement validateFullName;
    public void verifyValidateFullNameNull(String value){
        Assert.assertEquals(validateFullName.getText(),value);
    }
    //Chức năng tạo account _ Bỏ trống Xác nhận mật khẩu
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[2]/div[2]/div[1]")
    private WebElement validateRePassword;
    public void verifyValidateRePassword(String value){
        Assert.assertEquals(validateRePassword.getText(),value);
    }
    //Chức năng tạo account_ Nhập sai định dạng email
    @FindBy(xpath = "//div[contains(text(),'Vui lòng nhập chính xác địa chỉ email của bạn')]")
    private WebElement validateEmailInvalid;
    public void verifyValidateEmailInvalid(String value){
        Assert.assertEquals(validateEmailInvalid.getText(),value);
    }
    //Chức năng sủ dụng account đã đăng ký
    @FindBy(xpath = "//div[contains(text(),'Email đã được được đăng ký')]")
    private WebElement validateEmailRegistered;
    public void verifyValidateEmailRegistered(String value){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateEmailRegistered));
        Assert.assertEquals(validateEmailRegistered.getText(),value);
    }

}
