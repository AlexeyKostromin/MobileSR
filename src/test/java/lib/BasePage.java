package lib;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Arrays;

public class BasePage {
    protected static RemoteWebDriver driver;
    public static PlatformActions platformActions;
//    public static BasePage basePage;

//    private static BasePage instance;
//
//    public static BasePage getInstance() {
//        if (instance == null) {
//            instance = new BasePage();
//        }
//        return instance;
//    }


    public BasePage() {
        driver = (RemoteWebDriver) WebDriverRunner.getWebDriver();
        platformActions = new PlatformActions();
    }

    public static Boolean waitForElementIfExist(SelenideElement element, int timeInSeconds) {
        try {
            element.should(Condition.visible, Duration.ofSeconds(timeInSeconds));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    public static void swipeUpQuick() {
        swipeUp(300);
    }

    public static void swipeUp(int timeOfScroll) {
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
