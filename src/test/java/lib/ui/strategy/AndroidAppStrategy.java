package lib.ui.strategy;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import lib.BasePage;

import java.time.Duration;

public class AndroidAppStrategy implements AppActionsStrategy {
    private BasePage basePage;
    private AndroidDriver androidDriver;

    public AndroidAppStrategy() {
        this.basePage = new BasePage(this);
        this.androidDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
    }

    @Override
    public void activateApp() {
//        androidDriver.activateApp(getAndroidOptions().getAppPackage().get());
        String packageName = "com.sportradar.coaching.mobile";
        androidDriver.activateApp(packageName);
    }

    public void terminateApp() {
    }

    @Override
    public void closeAppFromAppSwitch() {
        androidDriver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));

        //Wait for the recent apps screen to open
        //TODO: replace sleep with check for the app is displayed/exist, and not exist after swipe
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        basePage.swipeUpQuick();

        androidDriver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    @Override
    public void runAppInBackground(Duration duration) {
        androidDriver.runAppInBackground(duration);
    }


}
