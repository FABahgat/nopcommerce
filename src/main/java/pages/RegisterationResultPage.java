package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterationResultPage {

    private WebDriver driver;
    private By statusAlert = By.className("result");

    public RegisterationResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(statusAlert));

        // Return the text of the alert
        return alertElement.getText();
    }

    public void logout() {

        WebElement logoutButton = driver.findElement(By.className("ico-logout"));
        logoutButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("demo"));
    }
    public RegisterationPage navigateToRegistrationPage() {
        driver.get("https://demo.nopcommerce.com/");
        return new RegisterationPage(driver);
    }
}