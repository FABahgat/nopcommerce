package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterationPage;
import pages.RegisterationResultPage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterationPage registerationPage;
    protected RegisterationResultPage registerationResultPage;

    @BeforeTest
    public void SetUp(){
       System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
       driver = new ChromeDriver();
       driver.get("https://demo.nopcommerce.com/");

       homePage = new HomePage(driver);
       loginPage = new LoginPage(driver);
       registerationPage = new RegisterationPage(driver);
       registerationResultPage = new RegisterationResultPage(driver);


      // driver.quit();
    }

}
