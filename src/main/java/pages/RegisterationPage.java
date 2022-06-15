package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class RegisterationPage {
    WebDriver driver;

    // Create constructor
    public RegisterationPage (WebDriver driver) {
        this.driver = driver;
    }

    // Locator

    By FirstName = By.xpath("//input[@name='firstname']");

    By LastName = By.xpath("//*[@name='lastname']");
    By Email = By.xpath("//*[@name='reg_email__']");
    By ConfEmail = By.xpath("//*[@name='reg_email_confirmation__']");
    By Password = By.id("password_step_input");
    By DaySelector = By.name("birthday_day");
    By MonthSelector = By.name("birthday_month");
    By YearSelector = By.name("birthday_year");
    By GenderRdoBtn = By.xpath("//input[@value='1']");
    By SignUpBtn = By.name("websubmit");

    By RegisterMessSuccess= By.cssSelector("div.result");
    By RegisterMessFailed = By.id("reg_error_inner");
    // Methods
    // Registration methods


    public boolean IsSignUpBtnDisplay() {

// set the implicit wait time to 20 Seconds
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver.findElement(SignUpBtn).isDisplayed();
    }




    public void userRegisration(String firstName, String lastName, String email,String ConfirmEmail, String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(FirstName)));
        wait.until(ExpectedConditions.elementToBeClickable(FirstName));
        // action
        driver.findElement(FirstName).sendKeys(firstName);

        // wait
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(LastName)));
        wait.until(ExpectedConditions.elementToBeClickable(LastName));
        // action
        driver.findElement(LastName).sendKeys(lastName);

        // wait
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Email)));
        wait.until(ExpectedConditions.elementToBeClickable(Email));
        // action
        driver.findElement(Email).sendKeys(email);


        // wait
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ConfEmail)));
        wait.until(ExpectedConditions.elementToBeClickable(ConfEmail));
        // action
        driver.findElement(ConfEmail).sendKeys(ConfirmEmail);


        // wait
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(Password)));
        wait.until(ExpectedConditions.elementToBeClickable(Password));
        // action
        driver.findElement(Password).sendKeys(password);

        Select selectoptions_Day = new Select(driver.findElement(DaySelector));
        selectoptions_Day.selectByIndex(8);
        Select selectoptions_Month = new Select(driver.findElement(MonthSelector));
        selectoptions_Month.selectByIndex(6);
        Select selectoptions_Year= new Select(driver.findElement(YearSelector));
        selectoptions_Year.selectByIndex(20);
        driver.findElement(GenderRdoBtn).click();
        driver.findElement(SignUpBtn).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public String GetRgisterMessSuccess() {

        return driver.findElement(RegisterMessSuccess).getText();
    }
    public String GetRegisterMessFailed() {

        return driver.findElement(RegisterMessFailed).getText();
    }
}
