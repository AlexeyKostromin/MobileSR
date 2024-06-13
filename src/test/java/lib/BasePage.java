package lib;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import lib.ui.strategy.AndroidAppStrategy;
import lib.ui.strategy.AppActionsStrategy;
import lib.ui.strategy.IOSAppStrategy;
import org.openqa.selenium.remote.RemoteWebDriver;

import static lib.Platform.isAndroid;
import static lib.Platform.isIOS;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
//    public static DriverMobile driverMobile;
//    public static RemoteWebDriver driver;
//
    private AppActionsStrategy appStrategy;

    public BasePage() {
        if (isAndroid()){
             appStrategy = new AndroidAppStrategy();
        } else if (isIOS()) {
             appStrategy = new IOSAppStrategy();
        }
    }

    static void initDriver() {
//        driverMobile = new DriverMobile();
//        driverMobile.initDriver();

        Configuration.browser = null;
        Configuration.browser = DriverMobile.class.getName();

        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    public void activateApp() {
        appStrategy.terminateApp();
//        var driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
////        driver.launchApp();
//        driverMobile.activateApp();
//        driver.close();

//        driver.terminateApp(driverMobile.getOptionsAndroid())
//        driver.closeApp();
    }

    public void terminateApp() {
        appStrategy.terminateApp();
    }

    public void closeApp() {
        closeWebDriver();
    }
}
