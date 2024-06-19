package lib;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lib.ui.strategy.AndroidAppActionsStrategy;
import lib.ui.strategy.AppActionsStrategy;
import lib.ui.strategy.IOSAppActionsStrategy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Arrays;

import static lib.Platform.isAndroid;
import static lib.Platform.isIOS;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    protected static RemoteWebDriver driver;
    private AppActionsStrategy appStrategy;

    public BasePage() {
        driver = (RemoteWebDriver) WebDriverRunner.getWebDriver();
        initAppStrategy();
    }

    protected void initAppStrategy() {
        if (isAndroid()) {
            appStrategy = new AndroidAppActionsStrategy(this);
        } else if (isIOS()) {
            appStrategy = new IOSAppActionsStrategy(this);
        } else {
            throw new RuntimeException("Cannot init app strategy!");
        }
    }


    public Boolean waitForElementIfExist(SelenideElement element, int timeInSeconds){
        try{
            element.should(Condition.visible, Duration.ofSeconds(timeInSeconds));
            return true;
        } catch (AssertionError e){
            return false;
        }
    }
    public void activateApp() {
        appStrategy.activateApp();
    }

    public void terminateApp() {
        appStrategy.terminateApp();
    }

    public void closeAppFromAppSwitch() {
        appStrategy.closeAppFromAppSwitch();
    }

    public void runAppInBackground(Duration duration) {
        appStrategy.runAppInBackground(duration);
    }

    public void closeApp() {
        closeWebDriver();
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
