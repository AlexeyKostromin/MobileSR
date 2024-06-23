package lib;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

import static com.codeborne.selenide.Selenide.sleep;

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

    public static void tryClickElementAndWaitNotVisible(SelenideElement element, int attempts) {
        int currentAttempts = 0;
        element.shouldBe(Condition.exist);
        while (currentAttempts < attempts) {
            try {
                WebElement webElement = element.toWebElement();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.elementToBeClickable(webElement));
                webElement.click();
                wait.until(ExpectedConditions.invisibilityOf(element));
                return;
            } catch (Exception e) {
                sleep(200);
            }
            currentAttempts++;
        }

        throw new RuntimeException(String.format("Could not perform click on element, after %d attempts", attempts));
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

//        driver.perform(Arrays.asList(swipe));
        driver.perform(Collections.singletonList(swipe));
    }


}
