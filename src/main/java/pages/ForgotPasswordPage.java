package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(),'Quên mật khẩu ?')]")
    private WebElement forgotPassword;
    public void clickForgotPassword(){
        clickElementByXpath(forgotPassword);
    }
    @FindBy(id = "forgot-password_email")
    private WebElement emailTextBox;
    public void inputEmail(String value){
        senKeyElementById(emailTextBox,value);
    }
    @FindBy(xpath = "//span[contains(text(),'Hủy bỏ')]")
    private WebElement cancelButton;
    public void clickCancelButton(){
        clickElementByXpath(cancelButton);
    }
    @FindBy(xpath = "//span[contains(text(),'Xác nhận')]")
    private WebElement acceptButton;
    public void clickAcceptButton(){
        clickElementByXpath(acceptButton);
    }
    @FindBy(xpath = "//div[contains(text(),'Vui lòng nhập chính xác địa chỉ email của bạn')]")
    private WebElement validateEmailInValid;
    public void verifyEmailInvalid(String value){
        Assert.assertEquals(validateEmailInValid.getText(),value);
    }
    @FindBy(xpath = "//div[contains(text(),'Bạn cần nhập thông tin này')]")
    private WebElement validateEmailNull;
    public void verifyEmailNull(String value){
        Assert.assertEquals(validateEmailNull.getText(),value);
    }
    @FindBy(xpath = "//div[contains(text(),'Email không hợp lệ')]")
    private WebElement validateEmailNotRegister;
    public void verifyValidateEmailNotRegister(String value){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validateEmailNotRegister));
        Assert.assertEquals(validateEmailNotRegister.getText(),value);
    }
    @FindBy(xpath = "//div[@id=\"root\"]//div[contains(text(),'Đặt lại mật khẩu')]")
    private WebElement validateEmail;
    public void verifySetLinkResetPassword(String value){
        Assert.assertEquals(validateEmail.getText(),value);
    }
}
