package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SEOPage extends BasePage {
    public SEOPage(WebDriver driver) {
        super(driver);
    }
    //Chuc nang search
    @FindBy(xpath = " //body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/a[1]/span[2]")
    private WebElement seoButton;
    public void clickSEOButton(){
        clickElementByXpath(seoButton);
    }
    @FindBy(id = "search-form_fullTextSearch")
    private WebElement searchBox;
    public void inputSearchBox(String value){
        senKeyElementById(searchBox,value);
    }
    @FindBy(xpath = "//button[@type=\"submit\"]//span[contains(text(),'Tìm kiếm')]")
    private WebElement searchButton;
    public void clickSearchButton(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(searchBox));
        clickElementByXpath(searchBox);
    }
    @FindBy(xpath = "//span[contains(text(),'Làm mới')]")
    private WebElement refreshButton;
    public void clickRefreshButton(){
        clickElementByXpath(refreshButton);
    }
    private String listResult = "//div[@class=\"ant-table-content\"]//td//span[contains(text(),'%s')]";
    public void verifyResultSearch(String value){
        Assert.assertTrue(getDynamicLocator(String.format(listResult,value)).getText().toLowerCase().contains(value));
    }
   // Chuc nang search - refresh
    @FindBy(xpath = "//input[@placeholder=\"SEO Slug\"]")
    private WebElement placeholderSearchBox;
    public void verifyPlaceHolderSearchBox(){
        Assert.assertTrue(placeholderSearchBox.isDisplayed());
    }

    //Chuc nang search khong co data
    @FindBy(xpath = "//div[contains(text(),'Không có dữ liệu')]")
    private WebElement validateNoData;
    public void verifyValidateNoData(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateNoData));
        Assert.assertEquals(validateNoData.getText(),"Không có dữ liệu");
    }

    //Chuc nao tao SEO
    @FindBy(xpath = "//span[contains(text(),'Tạo thuộc tính SEO')]")
    private WebElement createSEOButton;
    public void clickCreateSEOButton(){
        clickElementByXpath(createSEOButton);
    }
    @FindBy(id = "create-form_slug")
    private WebElement pathTextBox;
    public void inputPath(String value){
        senKeyElementById(pathTextBox,value);
    }
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]/span[1]")
    private WebElement createButton;
    public void clickCreateButton(){
        clickElementByXpath(createButton);
    }
    @FindBy(xpath = "//span[contains(text(),'Tạo thành công')]")
    private WebElement validateCreateSEOSuccess;
    public void verifyResult(String value){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateCreateSEOSuccess));
        Assert.assertEquals(validateCreateSEOSuccess.getText(),"Tạo thành công");
    }
    //Bo trong duong dan
    @FindBy(xpath = "//div[contains(text(),'Bạn cần nhập thông tin này')]")
    private WebElement validatePath;
    public void verifyValidatePath(){
        Assert.assertEquals(validatePath.getText(),"Bạn cần nhập thông tin này");
    }

    //Chuc nang edit Seo slug
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/a[1]/span[1]")
    private WebElement editButton;
    public void clickEditButton(){
        clickElementByXpath(editButton);
    }
    @FindBy(id = "create-form_slug")
    private WebElement path;
    public void editPath(String value){
        path.clear();
        senKeyElementById(path,value);
    }
    @FindBy(xpath = "//span[contains(text(),'Sửa thành công')]")
    private WebElement validateEditPath;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]/span[1]")
    private WebElement updateButton;
    public void clickUpdateButton(){
        clickElementByXpath(updateButton);
    }
    public void verifyValidateEditPath(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateEditPath));
        Assert.assertEquals(validateEditPath.getText(),"Sửa thành công");
    }

    //Chuc nang xoa Seo Slug
    @FindBy(xpath = " //body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[2]/a[1]/span[1]")
    private WebElement deleteSeoSlug;
    public void clickDeleteSeoSlug(){
        clickElementByXpath(deleteSeoSlug);
    }
    @FindBy(xpath = "//span[contains(text(),'Chấp thuận')]")
    private WebElement acceptButton;
    public void clickAcceptButton(){
        clickElementByXpath(acceptButton);
    }
    @FindBy(xpath = "//span[contains(text(),'Xóa thành công')]")
    private WebElement validateDeleteSuccess;
    public void verifyValidateDeleteSuccess(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateDeleteSuccess));
        Assert.assertEquals(validateDeleteSuccess.getText(),"Xóa thành công");
    }
    @FindBy(xpath = "//span[contains(text(),'Hủy bỏ')]")
    private WebElement cancelButton;
    public void clickCancelButton(){
        clickElementByXpath(cancelButton);
    }
}
