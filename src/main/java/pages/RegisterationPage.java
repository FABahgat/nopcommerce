package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegisterationPage {

    private WebDriver driver;
    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By dayOfBirth =  By.name("DateOfBirthDay");
    private By monthOfBirth =  By.name("DateOfBirthMonth");
    private By yearOfBirth =  By.name("DateOfBirthYear");
    private By companyNameField = By.id("Company");

    private By newsLetter = By.id("Newsletter");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By newLetter = By.id("Newsletter");




    public RegisterationPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectMale(){ driver.findElement(genderMale).click();
    }
    public void selectFemale(){ driver.findElement(genderFemale).click();
    }
   // public Select selectDayOfBirth = new Select(driver.findElement(dayOfBirth));
    // public Select selectMonthOfBirth= new Select (driver.findElement(monthOfBirth));
    // public Select selectYearOfBirth= new Select (driver.findElement(yearOfBirth));

    public RegisterationPage clickDropDownDay(){
        driver.findElement(dayOfBirth).click();
        return new RegisterationPage(driver);
    }
    public void selectFromDropDownDay(String option){
        Select dropdownDay = new Select(driver.findElement(dayOfBirth));
        dropdownDay .selectByValue(option);
    }
    public RegisterationPage clickDropDownMonth(){
        driver.findElement(monthOfBirth).click();
        return new RegisterationPage(driver);
    }
    public void selectFromDropDownMonth(String option){
        Select dropdownMonth = new Select(driver.findElement(monthOfBirth));
        dropdownMonth.selectByValue(option);
    }

    public RegisterationPage clickDropDownYear(){
        driver.findElement(yearOfBirth).click();
        return new RegisterationPage(driver);
    }
    public void selectFromDropDownYear(String option){
        Select dropdownYear = new Select(driver.findElement(yearOfBirth));
        dropdownYear.selectByValue(option);
    }

    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setCompanyName(String companyName){ driver.findElement(companyNameField).sendKeys(companyName);
    }

    public void selectNewsLetter(){ driver.findElement(newsLetter).click();}
    public void deselectNewsLetter() {
        driver.findElement(newsLetter).click();
    }

    public void setPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeToBe(passwordElement, "value", password));
    }

    public void setConfirmPassword(String confirmPassword) {
        WebElement confirmPasswordElement = driver.findElement(confirmPasswordField);
        confirmPasswordElement.sendKeys(confirmPassword);


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.attributeToBe(confirmPasswordElement, "value", confirmPassword));
    }
    public RegisterationResultPage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return new RegisterationResultPage(driver);
    }


}
