package PageObjects;

import Utility.Constants;
import Utility.Helper;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class LoginPage {

    public By noneAboveBtn = By.id("com.google.android.gms:id/cancel");
    public By skipBtn = By.id("net.one97.paytm:id/txtSkip");
    public By paytmLogo = By.id("net.one97.paytm:id/homeLogo");
    public By phnNumberField = By.id("et_registered_mobile");
    public By proceedBtn = By.id("viewProceedClick");


    public void clickNoneOfTheAbove(){
        Helper.click(noneAboveBtn);
    }

    public void verifyLoginScreenVisibility(){
        Helper.isElementVisible(skipBtn);
    }

    public void clickOnSkipBtn(){
        Helper.tapOnScreen(962,265);
    }

    public void verifyHomePageVisibility(){
        Helper.isElementVisible(paytmLogo);
    }

    public void enterPhoneNumber(){
        Helper.sendKeys(phnNumberField,"+91 98738 33973");
    }

    public void clickProceedBtn(){
        Helper.click(proceedBtn);
    }
}
