package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    //Chuc nang search khi khong co data tim kiem
    @FindBy(xpath = "//div[contains(text(),'Không có dữ liệu')]")
    private WebElement validateSearchNoData;
    public void verifyValidateSearchNoData(String value){
        Assert.assertEquals(validateSearchNoData.getText(),value);
    }
    //Chuc nang tao Tin tuc
    @FindBy(xpath = "//span[contains(text(),'Tạo sản phẩm')]")
    private WebElement createNewButton;
    public void clickCreateNewButton(){
        clickElementByXpath(createNewButton);
    }
    public void uploadPicture(String value){
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/img[1]")).sendKeys(System.getProperty("user.dir"));

    }

}
