package mobile.platformActions;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import mobile.ui.base.BasePage;

import java.time.Duration;

import static mobile.configs.DriverMobile.*;

public class PlatformActionsAndroid implements PlatformActionsStrategy {
    private AndroidDriver androidDriver;

    public PlatformActionsAndroid() {
        this.androidDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
    }

    @Override
    public void activateApp() {
        androidDriver.activateApp(getAppPackage());
    }

    @Override
    public void installApp() {
        if (androidDriver.isAppInstalled(getAppPackage())) {
            uninstallApp();
        }
        androidDriver.installApp(getAppPath());
    }

    @Override
    public void uninstallApp() {
        androidDriver.removeApp(getAppPackage());
    }

    @Override
    public void terminateApp() {
        androidDriver.terminateApp(getAppPackage());
    }

    @Override
    public void closeAppFromAppSwitch() {
        androidDriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

        //Wait for the recent apps screen to open
        //TODO: replace sleep with check for the app is displayed/exist, and not exist after swipe
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        BasePage.swipeUpQuick();
        BasePage.swipeUp(500);

        androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    @Override
    public void pressHomeButton() {

    }

    @Override
    public void runAppInBackground(Duration duration) {
        androidDriver.runAppInBackground(duration);
    }


}
