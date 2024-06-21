package lib;

import com.codeborne.selenide.WebDriverRunner;
import lib.ui.platformActions.PlatformActionsAndroid;
import lib.ui.platformActions.PlatformActionsStrategy;
import lib.ui.platformActions.PlatformActionsIOS;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

import static lib.Platform.isAndroid;
import static lib.Platform.isIOS;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class PlatformActions {
    protected static RemoteWebDriver driver;
    private PlatformActionsStrategy platformActions;

    public PlatformActions() {
        driver = (RemoteWebDriver) WebDriverRunner.getWebDriver();
        initPlatformActionsStrategy();
    }

    protected void initPlatformActionsStrategy() {
        if (isAndroid()) {
            platformActions = new PlatformActionsAndroid();
        } else if (isIOS()) {
            platformActions = new PlatformActionsIOS();
        } else {
            throw new RuntimeException("Cannot init app strategy!");
        }
    }

    public void activateApp() {
        platformActions.activateApp();
    }

    public void terminateApp() {
        platformActions.terminateApp();
    }

    public void installApp() {
        platformActions.installApp();
    }

    public void uninstallApp() {
        platformActions.uninstallApp();
    }

    public void attachToApp() {
    }

    public void closeAppFromAppSwitch() {
        platformActions.closeAppFromAppSwitch();
    }

    public void runAppInBackground(Duration duration) {
        platformActions.runAppInBackground(duration);
    }

    public void closeDriver() {
        closeWebDriver();
    }

    public void pressHomeButton() {
        platformActions.pressHomeButton();
    }

}
