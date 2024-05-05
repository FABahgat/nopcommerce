package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By registerationLink = By.className("ico-register");

    private By LoginLink = By.className("ico-login");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public RegisterationPage clickRegisterationButton(){
        driver.findElement(registerationLink).click();
        return new RegisterationPage(driver);
    }

    public LoginPage clickLoginLink(){
        driver.findElement(LoginLink).click();
        return new LoginPage(driver);
    }
}