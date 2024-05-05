package homePage;

import base.BaseTests;
import pages.LoginPage;

public class HomePage extends BaseTests {
    public void enterLoginPage(){
        LoginPage homepage = homePage.clickLoginLink();
    }
}
