package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SecurityCodePage {

    WebDriver driver;

    // Create constructor
    public SecurityCodePage (WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By SecurityCodTextBox = By.id("recovery_code_entry");
    By ContinueBtn = By.xpath("//button[@value='1']");
    By LinkTextNotReceiveCode =By.linkText("Didn't get a code?");
    By GetSSuccessMesseageAlert =By.linkText("Didn't get a code?");

    //methods
    public void EnterSecurityCode(String Code) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        // wait
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(SecurityCodTextBox)));
        wait.until(ExpectedConditions.elementToBeClickable(SecurityCodTextBox));
        // action
        driver.findElement(SecurityCodTextBox).sendKeys(Code);

    }

    //methods
    public String GetSuccessMessageAlert() {

        return driver.switchTo().alert().getText();

    }
    public String GetFailedMessageAlert() {

        return driver.switchTo().alert().getText();

    }

    public void AcceptAlert() {
        driver.switchTo().alert().accept();
    }
}
