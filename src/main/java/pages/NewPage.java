package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;

public class NewPage extends BasePage {
    public NewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = " //span[contains(text(),'Tin tức')]")
    private WebElement newButton;
    public void clickNewButton(){
        clickElementByXpath(newButton);
    }

    //Chuc nang search
    @FindBy(id = "search-form_fullTextSearch")
    private WebElement searchBox;
    public void inputSearchBox(String value){
        senKeyElementById(searchBox,value);
    }
    @FindBy(xpath = "//span[contains(text(),'Tìm kiếm')]")
    private WebElement searchButton;
    public void clickSearchButton(){
        clickElementByXpath(searchButton);
    }
    @FindBy(xpath = "//span[contains(text(),'Làm mới')]")
    private WebElement refreshButton;
    public void clickRefresh(){
        clickElementByXpath(refreshButton);
    }
    private String listNew = "//div[@class=\"ant-table-content\"]//td//span[contains(text(),'%s')]";
    public void verifyNew(String value){
        Assert.assertTrue(getDynamicLocator(String.format(listNew,value)).isDisplayed());
    }
    @FindBy(xpath = "//input[@placeholder=\"Tiêu đề tin tức\"]")
    private WebElement placeholderSearchBox;
    public void validatePlaceholderSearchBox(){
        Assert.assertTrue(placeholderSearchBox.isDisplayed());
    }
    //Chuc nang search khi khong co data tim kiem
    @FindBy(xpath = "//div[contains(text(),'Không có dữ liệu')]")
    private WebElement validateSearchNoData;
    public void verifyValidateSearchNoData(String value){
        Assert.assertEquals(validateSearchNoData.getText(),value);
    }
    //Chuc nang tao Tin tuc
    @FindBy(xpath = " //button//span[contains(text(),'Tạo tin tức')]")
    private WebElement createNewButton;
    public void clickCreateNewButton(){
        clickElementByXpath(createNewButton);
    }

    @FindBy(id = "create-form_image")
    private WebElement picture;
    public void uploadPicture() {
        senKeyElementById(picture,"C:\\Users\\ADMIN\\Pictures\\Timebucks\\emtuyt.jpg");
    }
    @FindBy(xpath = "create-form_status")
    private WebElement status;



}
