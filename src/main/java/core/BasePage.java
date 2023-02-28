package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final int TIME_OUT = 70;
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIME_OUT));
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT));
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getExplicitWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void clickElementByXpath(WebElement e){
        waitElementClickAble(e);
        e.click();
    }
    public void clickElementById(WebElement e){
        waitElementClickAble(e);
        e.click();
    }
    public void senKeyElementByXpath(WebElement e ,String value ){
        waitElementVisible(e);
        e.sendKeys(value);
    }
    public void senKeyElementById(WebElement e ,String value ){
        waitElementVisible(e);
        e.sendKeys(value);
    }
    public void selectElement(WebElement e ){
        waitElementClickAble(e);
        e.isSelected();
    }
    public void waitElementVisible(WebElement e){
        getExplicitWait().until(ExpectedConditions.visibilityOf(e));

    }
    public void waitElementClickAble(WebElement e){
        getExplicitWait().until(ExpectedConditions.elementToBeClickable(e));
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");
    }
    public void clearData(WebElement e){
        waitElementVisible(e);
        e.clear();
    }
    public WebElement getDynamicLocator(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        return driver.findElement(By.xpath(String.format(locator)));
    }
    public void getTextElementByXpath(WebElement e){
        waitElementVisible(e);
        e.getText();
    }
}
