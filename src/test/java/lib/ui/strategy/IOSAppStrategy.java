package lib.ui.strategy;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSAppStrategy implements AppActionsStrategy {
    private IOSDriver iosDriver;

    public IOSAppStrategy() {
        this.iosDriver = (IOSDriver) WebDriverRunner.getWebDriver();
    }

    @Override
    public void activateApp() {

    }

    @Override
    public void terminateApp() {

    }
}
