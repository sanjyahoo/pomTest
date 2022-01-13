package Utility;

import Support.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Helper extends Driver {

    static AppiumDriver driver1 = Driver.getDriver();


    public static MobileElement findElement(By by){
        waitUntilElementVisible(by);
        return (MobileElement) driver1.findElement(by);
    }

    public static void click(By by){
        System.out.println("running click");
        findElement(by).click();
    }

    public static void sendKeys(By by, String input){
        findElement(by).click();
        findElement(by).sendKeys(input);
    }

    public static void setImplicitWait(int seconds){
        driver1.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public static void isElementVisible(By by){
        Assert.assertTrue(findElement(by).isDisplayed());
    }

    public static void launchApp(){
        System.out.println("Launch  app");
        driver1.launchApp();
    }

    public static void waitUntilElementVisible(By by){
        System.out.println("Running wait");
        FluentWait wait = new WebDriverWait(driver1,55);
        wait.withTimeout(Duration.ofSeconds(55)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        wait.withMessage("App ERROR :: Waited "+ "55 Seconds");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void tapOnScreen(int x, int y){
        TouchAction touch = new TouchAction(driver1);
        touch.press(PointOption.point(x,y)).release().perform();
    }

    public static void scrollPageDown(){
        Dimension dimension = driver1.manage().window().getSize();

        Double screenHeightStart =  dimension.getHeight() * 0.62;
        int scrollStart = screenHeightStart.intValue();

        Double screenHeightEnd =  dimension.getHeight() * 0.10;
        int scrollEnd = screenHeightEnd.intValue();

        TouchAction touchAction = new TouchAction(driver1);
            touchAction.press(PointOption.point(530,scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(530,scrollEnd)).release().perform();

//        driver1.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(10)"));
    }

    public static void scrollFromLeftToRight(){
        Dimension dimension = driver1.manage().window().getSize();

        Double screenWidthStart =  dimension.getWidth() * 0.05;
        int scrollStart = screenWidthStart.intValue();

        Double screenWidthEnd =  dimension.getWidth() * 0.60;
        int scrollEnd = screenWidthEnd.intValue();

        TouchAction touchAction = new TouchAction(driver1);

            touchAction.press(PointOption.point(scrollStart,978)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(scrollEnd,978)).release().perform();
    }

    public static void scrollElementFromTopToBottom(By by){
        int x = findElement(by).getCenter().x;
        int height = driver1.manage().window().getSize().getHeight();

        Double startX = height * 0.15;
        int start = startX.intValue();

        Double endX = height * 0.50;
        int end = endX.intValue();

        TouchAction touchAction = new TouchAction(driver1);
        touchAction.press(PointOption.point(x,start)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).
                moveTo(PointOption.point(x,end)).release().perform();
    }

    public static void waitUntilElementEnable(By by){
        System.out.println("Running wait");
        FluentWait wait = new WebDriverWait(driver1,55);
        wait.withTimeout(Duration.ofSeconds(55)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
        wait.withMessage("App ERROR :: Waited "+ "55 Seconds");
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}
