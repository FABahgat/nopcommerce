package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTests {
    @Test
    void testSuccessfulLogin(){
       LoginPage loginpage = homePage.clickLoginLink();
       loginpage.setEmail("aaa@sss.com");
       loginpage.setPassword("abc123");
       loginpage.clickLoginButton();
    }
}
