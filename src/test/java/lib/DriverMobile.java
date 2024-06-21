package lib;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;
import static lib.Platform.*;


public class DriverMobile implements WebDriverProvider {
    private static RemoteWebDriver driver;//? WebDriver was here before!
    private static UiAutomator2Options androidOptions;
    private static UiAutomator2Options IOSOptions;
    private static final String appPackage = "com.sportradar.coaching.mobile";
    private static final String appActivity = "com.sportradar.coaching.mobile.MainActivity";

    @Nonnull
    @Override
    public RemoteWebDriver createDriver(@Nonnull Capabilities capabilities) {
        return initDriver();
    }


    public static UiAutomator2Options getAndroidOptions() {
        return androidOptions;
    }

    public static UiAutomator2Options getIOSOptions() {
        return IOSOptions;
    }

    public static String getAppPackage() {
        return appPackage;
    }

    public static String getAppActivity() {
        return appActivity;
    }

    public RemoteWebDriver initDriver() {
        if (isAndroid()) {
            driver = new AndroidDriver(getAppiumServerUrl(), getOptionsAndroid());
        } else if (isIOS()) {
            driver = new IOSDriver(getAppiumServerUrl(), getOptionsIOS());
        } else {
            throw new RuntimeException("Driver could not be determined");
        }
        return driver;
    }

    private UiAutomator2Options getOptionsAndroid() {
        UiAutomator2Options options = new UiAutomator2Options();
        androidOptions = options;

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion("14.0")
                .setDeviceName("Pixel6")
                .noReset()
                .setCapability("appium:disableIdLocatorAutocompletion", true);
        return options;
    }

    private UiAutomator2Options getOptionsAndroid1() {
        UiAutomator2Options options = new UiAutomator2Options();
        androidOptions = options;

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion("14.0")
                .setDeviceName("Pixel7")
                .setApp(getAppPath())
                .setAppPackage(appPackage)
                .setAppActivity(appActivity)
//                .noReset()
                .setAvdLaunchTimeout(Duration.ofSeconds(30))   //wait until Android emulator is started
                .setCapability("appium:disableIdLocatorAutocompletion", true);
        return options;
    }


    private UiAutomator2Options getOptionsIOS() {
        UiAutomator2Options options = new UiAutomator2Options();
        IOSOptions = options;

        options.setAutomationName(IOS_XCUI_TEST)
                .setPlatformName(IOS)
                .setPlatformVersion("17.5")
                .setDeviceName("iPhone 15")
                .setApp(getAppPath())
                .setAppPackage(appPackage)
                .setAppActivity(appActivity)
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

    public static String getAppPath() {
        if (isLocalHostRuntimeEnv()) {
            return getAppPathLocal();
        } else
            return getAppPathRemote();
    }

    private static String getAppPathLocal() {
        String appPath = "";

        String appNameAndroid = "com.sportradar.coaching.mobile-1.3.1-production-release.apk";
        String appNameIOS = "SynergySportsStaging-1.3.1.app";

        if (isAndroid()) {
            appPath = "src/test/resources/apps/" + appNameAndroid;
        } else if (isIOS()) {
            appPath = "src/test/resources/apps/" + appNameIOS;
        }

        File app = new File(appPath);
        if (!app.exists()) {
            throw new AssertionError("Failed to get application from: " + appPath);
        }
        return app.getAbsolutePath();
    }

    private static String getAppPathRemote() {
        String appPath = "";

        String appNameAndroid = "com.sportradar.coaching.mobile-1.3.1-production-release.apk";
        String appNameIOS = "SynergySportsStaging-1.3.1.app";

        if (isAndroid()) {
            appPath = "src/test/resources/apps/" + appNameAndroid;
        } else if (isIOS() && isMacRuntimeEnv()) {
            String localPath = "/Users/o.kostromin/@Builds/iOS/";
            appPath = localPath + appNameIOS;
        } else if (isIOS()) {
            appPath = "src/test/resources/" + appNameIOS;
        }

        File app = new File(appPath);
//        if (!app.exists()) {
//            throw new AssertionError("Failed to get application from: " + appPath);
//        }
        return appPath;
    }


//    private String getAppPath() {
//        String appVersion = "com.sportradar.coaching.mobile-1.2.4-production-release.apk";
////        String appVersion = "com.sportradar.coaching.mobile-1.3.1-production-release.apk";
////        String appUrl = "https://github.com/wikimedia/apps-android-wikipedia" +
////                "/releases/download/latest/" + appVersion;
//        String appPath = "src/test/resources/apps/" + appVersion;
//
//        File app = new File(appPath);
////        if (!app.exists()) {
////            try (InputStream in = new URL(appUrl).openStream()) {
////                copyInputStreamToFile(in, app);
////            } catch (IOException e) {
////                throw new AssertionError("Failed to download application", e);
////            }
////        }
//        return app.getAbsolutePath();
//    }
}
