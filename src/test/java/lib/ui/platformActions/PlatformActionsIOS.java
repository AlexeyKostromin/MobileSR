package lib.ui.platformActions;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

public class PlatformActionsIOS implements PlatformActionsStrategy {
    private IOSDriver iosDriver;

    public PlatformActionsIOS() {
        this.iosDriver = (IOSDriver) WebDriverRunner.getWebDriver();
    }

    @Override
    public void installApp() {

    }

    @Override
    public void uninstallApp() {

    }
    @Override
    public void activateApp() {
        //TODO:remove hardcoded value
        String bundleID = "com.sportradar.coaching.mobile.staging";
        iosDriver.activateApp(bundleID);
    }

    @Override
    public void terminateApp() {
        //TODO:remove hardcoded value
        String bundleID = "com.sportradar.coaching.mobile.staging";
        iosDriver.terminateApp(bundleID);
    }

    @Override
    public void closeAppFromAppSwitch() {
        swipeToOpenAppSwitch();

//        //Wait for the recent apps screen to open
//        //TODO: replace sleep with check for the app is displayed/exist, and not exist after swipe
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
           //TODO: add smart swipe to close desired app
//        pressHomeButton();
    }

    protected void swipeToOpenAppSwitch() {
        int yOffset = 6;

        Dimension size = iosDriver.manage().window().getSize();
        int centerX = size.width / 2;
        int startY = (int) (size.height - yOffset); // Start near the bottom
        int endY = (int) (size.height * 0.70);      // End near the top

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, startY))
                .addAction(finger.createPointerDown(0))
                .addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), centerX, startY))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), centerX, endY))
                .addAction(finger.createPointerUp(0));

        iosDriver.perform(Arrays.asList(swipe));
    }

    @Override
    public void pressHomeButton() {
        HashMap<String, String> args = new HashMap<>();
        args.put("name", "home");
        iosDriver.executeScript("mobile: pressButton", args);
    }

    @Override
    public void runAppInBackground(Duration duration) {

    }



}
