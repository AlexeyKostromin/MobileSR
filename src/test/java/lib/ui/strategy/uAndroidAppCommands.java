package lib.ui.strategy;

import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class uAndroidAppCommands {
    private AndroidDriver androidDriver;

    public uAndroidAppCommands() {
        androidDriver = (AndroidDriver)WebDriverRunner.getWebDriver();

    }

    public void activateApp() {
//        androidDriver.activateApp(getAndroidOptions().getAppPackage().get());
        String packageName = "com.sportradar.coaching.mobile";
        androidDriver.activateApp(packageName);
    }


    public void terminateApp1() {
        String appActivity = "com.sportradar.coaching.mobile";
        androidDriver.terminateApp(appActivity);
//        androidDriver.terminateApp(getAndroidOptions().getAppPackage().get());
    }

    public void terminateApp21() {
        String appActivity = "com.sportradar.coaching.mobile";
//        Map<String, Object> args = new HashMap<>();
//        args.put("package", appActivity); // Replace with your app's bundle ID
//        androidDriver.executeScript("mobile: terminateApp", args);

//        androidDriver.executeScript("mobile: terminateApp", ImmutableMap.of("package", "com.sportradar.coaching.mobile"));
        androidDriver.executeScript("mobile: terminateApp", ImmutableMap.of("appId", "com.sportradar.coaching.mobile"));
    }

    public void terminateApp22() {
        String appActivity = "com.sportradar.coaching.mobile";
        Map<String, Object> args = new HashMap<>();
        args.put("package", appActivity); // Replace with your app's bundle ID
        androidDriver.executeScript("mobile: terminateApp", args);


    }


    //To use shell you need to start appium with parameters
    //appium --allow-insecure=adb_shell
    public void terminateAppCloseAll(){
        androidDriver.executeScript("mobile: shell", new HashMap<String, Object>() {{
            put("command", "input");
            put("args", List.of("keyevent", "KEYCODE_APP_SWITCH"));
        }});

        // Wait for the recent apps screen to open
//        try {
//            Thread.sleep(2000); // This is to wait for 2 seconds; adjust as needed
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        $(By.xpath("//android.widget.Button[contains(@text, 'Clear all')]")).click();
    }


    public void terminateAppShell(){
        Map<String, Object> args = new HashMap<>();
        args.put("command", "am");
        args.put("args", List.of("force-stop", "com.sportradar.coaching.mobile"));

        androidDriver.executeScript("mobile: shell", args);
    }

    public void terminateAppShell2(){
        Map<String, Object> args = new HashMap<>();
        args.put("command", "am force-stop");
        args.put("args", List.of("com.yourapp.packagename")); // Replace 'com.yourapp.packagename' with your app's actual package name

        androidDriver.executeScript("mobile: shell", args);
    }
    public void terminateAppADB() {
        String appPackageName = "com.sportradar.coaching.mobile";
        try {
            Runtime.getRuntime().exec("adb shell am force-stop " + appPackageName);
            System.out.println("App terminated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void terminateApp2() {
//        Logger.log();
        String appID = null;
        if (androidDriver != null) {
            try {
                if (androidDriver instanceof AndroidDriver) {
                    appID = (String) androidDriver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
                } else if (androidDriver ==null) {//iosDriver here
                    appID = String.valueOf(androidDriver.getCapabilities().getCapability(IOSMobileCapabilityType.BUNDLE_ID));
                } else
                    throw new RuntimeException("unknown driver type");
//                    Assert.fail(createAssertionLog("unknown driver type"));
                if (appID != null)
                    ((InteractsWithApps) androidDriver).terminateApp(appID);
            } catch (Exception e) {
                System.err.println(e);
//                Logger.logError(e.getMessage());
            }
        }
//        return this;
    }

    public void terminateAppIOS(){
        ((InteractsWithApps) androidDriver).terminateApp("appID");
        //where appID is APP_PACKAGE (Android) or BUNDLE_ID (iOS)
        //PROD: com.sportradar.coaching.mobile
        //STAGING: com.sportradar.coaching.mobile.staging
    }




}
