package mobile.configs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static io.appium.java_client.remote.MobilePlatform.IOS;
import static mobile.configs.Platform.*;

public class Initializer {

    private static RemoteWebDriver driver;

    static Properties config = new Properties();

    static {
        try (InputStream input = Initializer.class.getClassLoader().getResourceAsStream("config.ios.properties")) {
            if (input == null) {
//                log.error("Unable to find config file");
            }
            config.load(input);
        } catch (Exception e){
//            log.error("Failed load configuration", e);
            throw new ExceptionInInitializerError();
        }
    }

    public static RemoteWebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static RemoteWebDriver initDriver() {
        if (isAndroid()) {
            driver = new AndroidDriver(getAppiumServerUrl(), getOptionsAndroid());
        } else if (isIOS()) {
            driver = new IOSDriver(getAppiumServerUrl(), getOptionsIOS());
        } else {
            throw new RuntimeException("Driver could not be determined");
        }
        return driver;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.getProperty("appiumURL"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private UiAutomator2Options getOptionsIOS() {
        UiAutomator2Options options = new UiAutomator2Options();
//        UiAutomator2Options IOSOptions = options;

        options.setAutomationName(IOS_XCUI_TEST)
                .setPlatformName(IOS)
                .setPlatformVersion(config.getProperty("platform"))
                .setDeviceName(config.getProperty("deviceName"))
                .noReset()
                .setAvdLaunchTimeout(Duration.ofSeconds(30));   //wait until Android emulator is started
//                .setCapability("appium:disableIdLocatorAutocompletion", true);
        return options;
    }




}
