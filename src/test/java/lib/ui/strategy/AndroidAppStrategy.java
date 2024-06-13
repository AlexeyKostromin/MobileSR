package lib.ui.strategy;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static lib.DriverMobile.getAndroidOptions;
import static lib.DriverMobile.getIOSOptions;

public class AndroidAppStrategy implements AppActionsStrategy{
    private AndroidDriver androidDriver;

    public AndroidAppStrategy() {
        androidDriver = (AndroidDriver)WebDriverRunner.getWebDriver();

    }

    @Override
    public void activateApp() {
        androidDriver.activateApp(getAndroidOptions().getAppPackage().get());
    }

    @Override
    public void terminateApp() {
        androidDriver.terminateApp(getAndroidOptions().getAppPackage().get());
    }


}
