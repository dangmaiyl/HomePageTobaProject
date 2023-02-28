package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FQAPage extends BasePage {
    public FQAPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[6]/a[1]/span[2]")
    private WebElement fqaButton;
    public void clickFQAButton(){
        clickElementByXpath(fqaButton);
    }
    //Chuc nang search FQA
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
    @FindBy(xpath = " //span[contains(text(),'Làm mới')]")
    private WebElement reFreshButton;
    public void clickRefreshButton(){
        clickElementByXpath(reFreshButton);
    }
    private String listFQA = "//div[@class=\"ant-table-content\"]//td//span[contains(text(),'%s')]";
    public void verifyValidateFQA(String value){
        Assert.assertTrue(getDynamicLocator(String.format(listFQA,value)).isDisplayed());
    }
    @FindBy(xpath = " //div[contains(text(),'Không có dữ liệu')]")
    private WebElement validateNoData;
    public void verifyValidateNoData(String value){
        Assert.assertEquals(validateNoData.getText(),value);
    }
    //Chuc nang them moi FQA
    @FindBy(xpath = "//span[contains(text(),'Tạo FQA')]")
    private WebElement createFQAButton;
    public void clickCreateFQAButton(){
        clickElementByXpath(createFQAButton);
    }
    @FindBy(id = "create-form_fqaDetails_0_name")
    private WebElement titleFQATextBox;
    public void inputTitleFQA(String value){
        senKeyElementByXpath(titleFQATextBox,value);
    }

    public void
    inputContent(){
       driver.switchTo().frame("tiny-react_55413265211677579228273_ifr");
       getExplicitWait().until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("p"))));
       driver.findElement(By.tagName("p")).sendKeys("hi");

    }
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement createButton;
    public void clickCreateButton(){
        clickElementByXpath(createButton);
    }
    //Chuc nang tao mơi FQA nhưng bo trong Noi dung
    @FindBy(xpath = "//p[contains(text(),'Bạn cần nhập thông tin này')]")
    private WebElement validateContent;
    public void verifyValidateContent(String value){
        Assert.assertEquals(validateContent.getText(),value);
    }
    @FindBy(xpath = "//div[contains(text(),'Bạn cần nhập thông tin này')]")
    private WebElement validateTitle;
    public void verifyValidateTitle(String value){
        Assert.assertEquals(validateTitle.getText(),value);
    }

}
