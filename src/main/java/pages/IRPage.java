package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class IRPage extends BasePage {
    public IRPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/a[1]/span[2]")
    private WebElement irButton;
    public void clickIRButton(){
        clickElementByXpath(irButton);
    }
    //Chuc nang search

    @FindBy(id = "search-form_fullTextSearch")
    private WebElement searchBox;
    public void inputSearchBox(String value){
        senKeyElementById(searchBox,value);
    }
    @FindBy(xpath = "//span[contains(text(),'Tìm kiếm')]")
    private WebElement searchButton;
    public void clickSearchBox(){
        clickElementByXpath(searchButton);
    }
    @FindBy(xpath = " //span[contains(text(),'Làm mới')]")
    private WebElement refreshButton;
    public void clickRefreshButton(){
        clickElementByXpath(refreshButton);
    }
    private  String listResult = "//div[@class=\"ant-table-content\"]//td//span[contains(text(),'%s')]";
    public void verifyResult (String value){
        Assert.assertTrue(getDynamicLocator(String.format(listResult,value)).isDisplayed());
    }
    //Chuc nang search khi khong co data tim kiem
    @FindBy(xpath = "//div[contains(text(),'Không có dữ liệu')]")
    private WebElement validateSearch;
    public void verifyValidateSearch(){
        Assert.assertEquals(validateSearch.getText(),"Không có dữ liệu");
    }
    //Chuc nang tao IR

    @FindBy(xpath = "//span[contains(text(),'Tạo IR')]")
    private WebElement createIRButton;
    public void clickCreateIRButton(){
        clickElementByXpath(createIRButton);
    }
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/img[1]")
    private WebElement picture;
    public void uploadPicture(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(picture));
        senKeyElementByXpath(picture,"C:\\Users\\ADMIN\\Pictures\\Timebucks\\ahihi.jpg");
    }
    @FindBy(xpath = " //span[contains(text(),'Tải lên')]")
    private WebElement file;
    public void uploadFile(){
        senKeyElementByXpath(file,"C:\\Users\\ADMIN\\Pictures\\Timebucks\\ahihi.jpg");
    }
    @FindBy(id = "create-form_release_date")
    private WebElement date;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]")
    private WebElement selectTime;
    public void selectTime(){
        clickElementById(date);
        clickElementByXpath(selectTime);
    }
    @FindBy(id = "create-form_createDetails_0_name")
    private WebElement name;
    public void inputName(String value){
        senKeyElementById(name,value);
    }
    @FindBy(id = "create-form_createDetails_0_content")
    private WebElement contentIR;
    public void inputContentIR(String value){
        senKeyElementById(contentIR,value);
    }
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/button[1]/span[1]")
    private WebElement createButton;
    public void clickCreateButton(){
        clickElementByXpath(createButton);
    }
    @FindBy(xpath = "//div[contains(text(),'Hành động thực hiện hoàn tất.')]")
    private WebElement validateCreateIRSuccess;
    public void verifyvalidateCreateIRSuccess(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateCreateIRSuccess));
        Assert.assertEquals(validateCreateIRSuccess.getText(),"Hành động thực hiện hoàn tất.");
    }
    //Chuc nang tao IR - Bo trong anh
    @FindBy(xpath = "//div[contains(text(),'Bạn cần chọn ảnh')]")
    private WebElement validatePicture;
    public void verifyValidatePicture (){
        Assert.assertEquals(validatePicture.getText(),"Bạn cần chọn ảnh");
    }

    //Chuc nang tao IR - Bo trong file
    @FindBy(xpath = " //div[contains(text(),'Bạn cần nhập thông tin này')]")
    private WebElement validateFile;
    public void verifyValidateFile (){
        Assert.assertEquals(validateFile.getText(),"Bạn cần nhập thông tin này");
    }
    //Chuc nang tao IR - Bo trong thoi gian phat hanh
    @FindBy(xpath = " //div[contains(text(),'Vui lòng chọn')]")
    private WebElement validateTime;
    public void verifyValidateTime (){
        Assert.assertEquals(validateTime.getText(),"Vui lòng chọn");
    }
    //Chuc nang tao IR - Bo trong ten
    @FindBy(xpath = " //div[contains(text(),'Bạn cần nhập thông tin này')]")
    private WebElement validateName;
    public void verifyValidateName (){
        Assert.assertEquals(validateName.getText(),"Bạn cần nhập thông tin này");
    }

    //Chuc nang tao IR - Bo trong noi dung
    @FindBy(xpath = " //div[contains(text(),'Bạn cần nhập thông tin này')]")
    private WebElement validateContent;
    public void verifyValidateContent (){
        Assert.assertEquals(validateContent.getText(),"Bạn cần nhập thông tin này");
    }
    //Chuc nang Edit IR
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[1]/a[1]/span[1]")
    private WebElement editButton;
    public void clickEditButton(){
        clickElementByXpath(editButton);
    }
    /////////////////////
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/span[1]/img[1]")
    private WebElement editPicture;
    public void editPicture(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(editPicture));
        senKeyElementByXpath(picture,"C:\\Users\\ADMIN\\Pictures\\Timebucks\\ahihi.jpg");
    }
    @FindBy(xpath = " //span[contains(text(),'Tải lên')]")
    private WebElement editFile;
    public void editFile(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(editFile));
        senKeyElementByXpath(file,"C:\\Users\\ADMIN\\Pictures\\Timebucks\\ahihi.jpg");
    }
    @FindBy(id = "create-form_release_date")
    private WebElement editDate;
    @FindBy(xpath = "//body/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]")
    private WebElement editTime;
    public void editSelectTime(){
        clickElementById(editDate);
        clickElementByXpath(editTime);
    }
    @FindBy(id = "create-form_createDetails_0_name")
    private WebElement editName;
    public void ediName(String value){
        editName.clear();
        senKeyElementById(name,value);
    }
    @FindBy(id = "create-form_createDetails_0_content")
    private WebElement editContentIR;
    public void editContentIR(String value){
        editContentIR.clear();
        senKeyElementById(contentIR,value);
    }
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/button[1]")
    private WebElement updateButton;
    public void clickUpdateButton(){
        clickElementByXpath(updateButton);
    }
    @FindBy(xpath = "//span[contains(text(),'Sửa thành công')]")
    private WebElement validateUpdateIRSuccess;
    public void verifyValidateUpdateIRSuccess(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateUpdateIRSuccess));
        Assert.assertEquals(validateUpdateIRSuccess.getText(),"Sửa thành công");
    }

    //Chuc nang xoa IR
    @FindBy(id = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/div[2]/a[1]/span[1]")
    private WebElement deleteButton;
    public void clickDeleteButton(){
        clickElementByXpath(deleteButton);
    }
    @FindBy(xpath = "//span[contains(text(),'Chấp thuận')]")
    private WebElement acceptButton;
    public void clickAcceptButton(){
        clickElementByXpath(acceptButton);
    }
    @FindBy(xpath = "//span[contains(text(),'Xóa thành công')]")
    private WebElement validateDeleteIR;
    public void verifyValidateDeleteIR(){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateDeleteIR));
        Assert.assertEquals(validateDeleteIR.getText(),"Xóa thành công");
    }
    @FindBy(xpath = "//span[contains(text(),'Hủy bỏ')]")
    private WebElement canceltButton;
    public void clickCancelButton(){
        clickElementByXpath(canceltButton);
    }
    


}
