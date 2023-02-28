package pages;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    // Đăng nhập thành công

    @FindBy(id = "login_email")
    private WebElement email;
    @FindBy(id = "login_password")
    private WebElement password;
    @FindBy(xpath = "//button[@form=\"login\"]")
    private WebElement logInButton;
    @FindBy(id = "kt_aside_logo")
    private WebElement homepage;

    public void navigateToHomePage(String url) {
        getDriver().get(url);
    }

    public void inputEmail(String value) {
        senKeyElementById(email, value);
    }

    public void inputPassword(String value) {
        senKeyElementById(password, value);
    }

    public void clickLogInButton() {
        clickElementByXpath(logInButton);
    }

    public void verifyHomepage() {
        Assert.assertTrue(homepage.isDisplayed());
    }

    //Đăng nhập không thành công
    //Sai định dạng email
    @FindBy(xpath = "//div[contains(text(),'Vui lòng nhập chính xác địa chỉ email của bạn')]")
    private WebElement validateEmail;

    public void validateEmailNotValid(String value) {
        Assert.assertEquals(validateEmail.getText(), value);
    }

    //Bỏ trống email
    @FindBy(xpath = "(//div[text()='Bạn cần nhập thông tin này'])[1]")
    private WebElement validateEmailIsNull;

    public void verifyEmailIsNull(String value) {
        Assert.assertEquals(validateEmailIsNull.getText(), value);
    }

    //Bo trong password
    @FindBy(xpath = "(//div[text()='Bạn cần nhập thông tin này'])[2]")
    private WebElement validatePasswordIsNull;

    public void verifyPasswordIsNull(String value) {
        Assert.assertEquals(validatePasswordIsNull.getText(), value);
    }

    //Bo trong email + password
    @FindBy(xpath = "//div[text()='Bạn cần nhập thông tin này']")
    private List<WebElement> listValidate;

    public void verifyEmailAndPassWordNull(String value) {
        getExplicitWait().until(ExpectedConditions.visibilityOfAllElements(listValidate));
        for (WebElement validate : listValidate) {
            Assert.assertEquals(validate.getText(), value);
        }

    }

    //Nhap sai dinh dang password
    @FindBy(xpath = "//div[contains(text(),'Mật Khẩu không hợp lệ')]")
    private WebElement validatePasswordInValid;

    public void verifyValidatePasswordInValid(String value){
        getExplicitWait().until(ExpectedConditions.visibilityOf(validatePasswordInValid));
         Assert.assertEquals(validatePasswordInValid.getText(),value);
   }
    //Nhap sai tai khoan chua tao
    @FindBy(xpath = "//div[text()='Email không hợp lệ']")
    private WebElement accountInvalid;

    public void verifyAccountInvalid(String value){
        Assert.assertEquals(accountInvalid.getText(),value);
    }


}
