package Test;

import PageObjects.LoginPage;
import Support.Driver;
import Utility.Helper;
import org.testng.annotations.Test;

public class HomePageTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void tc_001_findNoneBtn(){
        loginPage.clickNoneOfTheAbove();
    }
}
