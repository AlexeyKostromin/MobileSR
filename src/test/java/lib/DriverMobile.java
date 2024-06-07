package lib;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;


public class DriverMobile implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        return getDriver();
    }

    public WebDriver getDriver() {
        if (Platform.isAndroid()) {
            return new AndroidDriver(getAppiumServerUrl(), getOptionsAndroid());
        } else if (Platform.isIOS()) {
            return new IOSDriver(getAppiumServerUrl(), getOptionsIOS());
        } else {
            throw new RuntimeException("Driver could not be determined");
        }
    }

    private UiAutomator2Options getOptionsAndroid() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion("14.0")
                .setDeviceName("Pixel7")
                .setApp(getAppPath())
                .setAppPackage("com.sportradar.coaching.mobile")
                .setAppActivity("com.sportradar.coaching.mobile.MainActivity")
                .setAvdLaunchTimeout(Duration.ofSeconds(30))   //wait until Android emulator is started
                .setCapability("appium:disableIdLocatorAutocompletion", true);
        return options;
    }

    private UiAutomator2Options getOptionsIOS() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(IOS_XCUI_TEST)
                .setPlatformName(IOS)
                .setPlatformVersion("16.0")
                .setDeviceName("iPhone 14")
                .setApp(getAppPath())
                .setAppPackage("com.sportradar.coaching.mobile")
                .setAppActivity("com.sportradar.coaching.mobile.MainActivity")
                .setAvdLaunchTimeout(Duration.ofSeconds(30));   //wait until Android emulator is started
//                .setCapability("appium:disableIdLocatorAutocompletion", true);
        return options;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(Platform.getAppiumUrlVar());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static URL getAppiumUrl() throws MalformedURLException {
//        if (Platform.getInstance().isLocalHostRuntimeEnv()){
//            return new URL("http://127.0.0.1:4723/");
//        } else if (Platform.getInstance().isWindowsRuntimeEnv()) {
//            return new URL("http://192.168.0.204:4723/");
//        } else if (Platform.getInstance().isMacRuntimeEnv()) {
//            return new URL("http://192.168.0.202:4723/");
//        }
//    }


    //https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk
    private String getAppPath() {
        String appVersion = "com.sportradar.coaching.mobile-1.2.0-production.apk";
//        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia" +
//                "/releases/download/latest/" + appVersion;
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
//        if (!app.exists()) {
//            try (InputStream in = new URL(appUrl).openStream()) {
//                copyInputStreamToFile(in, app);
//            } catch (IOException e) {
//                throw new AssertionError("Failed to download application", e);
//            }
//        }
        return app.getAbsolutePath();
    }
}
