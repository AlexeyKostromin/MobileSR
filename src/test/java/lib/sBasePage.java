package lib;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lib.ui.platformActions.PlatformActionsAndroid;
import lib.ui.platformActions.PlatformActionsIOS;
import lib.ui.platformActions.PlatformActionsStrategy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static lib.Platform.isAndroid;
import static lib.Platform.isIOS;

public class sBasePage {
    protected static RemoteWebDriver driver;
    private PlatformActionsStrategy appStrategy;

    public sBasePage() {
        driver = (RemoteWebDriver) WebDriverRunner.getWebDriver();
        initPlatformActionsStrategy();
    }

    protected void initPlatformActionsStrategy() {
        if (isAndroid()) {
//            appStrategy = new PlatformActionsAndroid(this);
        } else if (isIOS()) {
//            appStrategy = new PlatformActionsIOS(this);
        } else {
            throw new RuntimeException("Cannot init app strategy!");
        }
    }


    public Boolean waitForElementIfExist(SelenideElement element, int timeInSeconds) {
        try {
            element.should(Condition.visible, Duration.ofSeconds(timeInSeconds));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    public void activateApp() {
        appStrategy.activateApp();
    }

    public void terminateApp() {
        appStrategy.terminateApp();
    }

    public void installApp() {
        appStrategy.installApp();
    }

    public void uninstallApp() {
        appStrategy.uninstallApp();
    }

    public void attachToApp() {

    }

    public void closeAppFromAppSwitch() {
        appStrategy.closeAppFromAppSwitch();
    }

    public void runAppInBackground(Duration duration) {
        appStrategy.runAppInBackground(duration);
    }

    public void closeDriver() {
        closeWebDriver();
    }

    public void pressHomeButton() {
        appStrategy.pressHomeButton();
    }

    public void swipeUpQuick() {
        swipeUp(300);
    }

    public void swipeUp(int timeOfScroll) {
        Dimension size = driver.manage().window().getSize();
        int centerX = size.width / 2;
        int startY = (int) (size.height * 0.70); // Start near the bottom
        int endY = (int) (size.height * 0.20); // End near the top

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, startY))
                .addAction(finger.createPointerDown(0))
                .addAction(finger.createPointerMove(Duration.ofMillis(timeOfScroll), PointerInput.Origin.viewport(), centerX, endY))
                .addAction(finger.createPointerUp(0));

        driver.perform(Arrays.asList(swipe));
    }


}
