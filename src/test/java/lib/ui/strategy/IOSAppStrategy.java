package lib.ui.strategy;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.ios.IOSDriver;
import lib.BasePage;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class IOSAppStrategy implements AppActionsStrategy {
    private BasePage basePage;
    private IOSDriver iosDriver;

    public IOSAppStrategy(BasePage basePage) {
        this.basePage = basePage;
        this.iosDriver = (IOSDriver) WebDriverRunner.getWebDriver();
    }

    @Override
    public void activateApp() {

    }

    @Override
    public void terminateApp() {

    }

    @Override
    public void closeAppFromAppSwitch() {

    }

    @Override
    public void runAppInBackground(Duration duration) {

    }
}
