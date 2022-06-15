package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

        WebDriver driver;

        // Create constructor
        public ProfilePage (WebDriver driver) {
            this.driver = driver;
        }

        // Locator
        By WelcomeMesseage = By.linkText("Welcome to Facebook, Ahmed");
      By LogOutBtn = By.linkText("Welcome to Facebook, Ahmed");

    public String GetWelcomMessaeagonProfile() {

        return driver.findElement(WelcomeMesseage).getText();

    }
    public Boolean IsLogOutButtonIsDisplay() {

        return driver.findElement(LogOutBtn).isDisplayed();

    }
}
