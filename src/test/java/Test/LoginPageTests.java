package Test;

import PageObjects.LoginPage;
import Support.Driver;
import Utility.Helper;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTests {

    LoginPage loginPage = new LoginPage();


    @Test
    public void tc_001_verifyHomePageOnAppLaunch() throws InterruptedException {
        Helper.launchApp();
        loginPage.clickNoneOfTheAbove();
        loginPage.verifyLoginScreenVisibility();
        loginPage.enterPhoneNumber();
        loginPage.clickProceedBtn();
        System.out.println("Hello");
    }
}
