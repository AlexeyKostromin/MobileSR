package lib;

import com.codeborne.selenide.WebDriverProvider;
//import config.owner.LocalConfigOwner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import org.aeonbits.owner.ConfigFactory;
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


public class LocalDriverSR implements WebDriverProvider {
    UiAutomator2Options uiAutomator2Options;
//    static LocalConfigOwner localConfig;

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

//        localConfig = ConfigFactory.create(LocalConfigOwner.class, System.getProperties());

        uiAutomator2Options = new UiAutomator2Options();
        UiAutomator2Options options = uiAutomator2Options;

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion("14.0")
                .setDeviceName("Pixel7")
                .setApp(getAppPath())
                .setAppPackage("com.sportradar.coaching.mobile")
                .setAppActivity("com.sportradar.coaching.mobile.MainActivity")
                .setCapability("appium:disableIdLocatorAutocompletion", true);
        return getDriver();


//        uiAutomator2Options = new UiAutomator2Options();
//        UiAutomator2Options options = uiAutomator2Options;
//
//        options.setAutomationName(ANDROID_UIAUTOMATOR2)
//                .setPlatformName(ANDROID)
//                .setPlatformVersion(localConfig.osVersion())
//                .setDeviceName(localConfig.device())
//                .setApp(getAppPath())
//                .setAppPackage(localConfig.appPackage())      //get this from developer
//                .setAppActivity(localConfig.appActivity())    //get this from developer
//                .setCapability("appium:disableIdLocatorAutocompletion", true);
//        return getDriver();
    }

    private UiAutomator2Options getCapabilitiesAndroid() {
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

    private UiAutomator2Options getCapabilitiesIOS() {
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



//    public WebDriver getDriver() {
//        if (localConfig.osType().equals("android")) {
//            return getAndroidDriver(uiAutomator2Options);
//        } else if (localConfig.osType().equals("ios")) {
//            return getIosDriver(uiAutomator2Options);
//        } else {
//            return null;
//        }
//    }
    public WebDriver getDriver() {
        if (Platform.isAndroid()) {
            return new AndroidDriver(getAppiumServerUrl(), uiAutomator2Options);
        } else if (Platform.isIOS()) {
            return new IOSDriver(getAppiumServerUrl(), uiAutomator2Options);
        } else {
            throw new RuntimeException("Driver could not be determined");
        }
    }

//    public AndroidDriver getAndroidDriver(UiAutomator2Options options) {
//        return new AndroidDriver(getAppiumServerUrl(), options);
//    }
//
//    public IOSDriver getIosDriver(UiAutomator2Options options) {
//        return new IOSDriver(getAppiumServerUrl(), options);
//    }

//    private void setAppiumUrl() {
//        if (isWindowsRuntimeEnv()) {
//            APPIUM_URL = WINDOWS_APPIUM_URL;
//        } else if (isMacRuntimeEnv()) {
//            APPIUM_URL = MAC_APPIUM_URL;
//        } else if (isLocalHostRuntimeEnv()) {
//            APPIUM_URL = LOCALHOST_APPIUM_URL;
//        }
//    }

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


//    public static URL getAppiumServerUrl() {
//        try {
//            return new URL("http://" + localConfig.url());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
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
