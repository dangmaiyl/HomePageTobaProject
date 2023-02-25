package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

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

    // Chức năng tạo account

    @FindBy(xpath = "//button/span[contains(text(),'Tạo tài khoản')]")
    private WebElement createAccountButton;
    @FindBy(id = "create-form_email")
    private WebElement email;
    @FindBy(id = "create-form_password")
    private WebElement password;
    @FindBy(id = "create-form_fullName")
    private WebElement fullName;
    @FindBy(id = "create-form_repassword")
    private WebElement rePassword;
    @FindBy(xpath = "//button/span[contains(text(),'Tạo tài khoản')]")
    private WebElement createButton;


}
