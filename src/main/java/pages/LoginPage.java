package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    // Create constructor
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By CreateNewAccountBtn = By.xpath("//*[@data-testid='open-registration-form-button']");
    By EmailTextFailed = By.xpath("//*[@data-testid='royal_email']");
    By PaaswordTextLabel =By.xpath("//*[@data-testid='royal_pass']");
    By LoginBtn =By.xpath("//button[@value='1']");

    // Methods
    // Registration methods
    public void OpenRegisterPage() {

        driver.findElement(CreateNewAccountBtn).click();

    }

    public void LoginToFacebook(String Email, String password) {

        driver.findElement(EmailTextFailed).sendKeys(Email);
        driver.findElement(PaaswordTextLabel).sendKeys(password);
        driver.findElement(LoginBtn).click();
    }
    public Boolean IsLoginButtonIsDisplay() {

        return driver.findElement(LoginBtn).isDisplayed();

    }
}
