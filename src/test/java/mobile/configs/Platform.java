package mobile.configs;

import lombok.Getter;

import java.io.InputStream;
import java.util.Properties;


public class Platform {
    private static String platform;
    private static String runtimeEnv;
    private static String appiumUrl;
    private final static String PLATFORM_ANDROID = "android";
    private final static String PLATFORM_IOS = "ios";
    private static String buildType;
    @Getter
    private static String platformVersion;
    @Getter
    private static String deviceName;

//    private final static String RUNTIME_ENV_LOCALHOST = "localHostRuntimeEnv";
//    private final static String RUNTIME_ENV_WINDOWS = "windowsRuntimeEnv";
//    private final static String RUNTIME_ENV_MAC = "macRuntimeEnv";
//    private final static String MAC_APPIUM_URL = "http://192.168.0.202:4723/";

    private static Platform instance;

    private Platform() {
        initConfig();
    }

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    static Properties config = new Properties();

    static {
        try (InputStream input = Platform.class.getClassLoader().getResourceAsStream("config.ios.properties")) {
            if (input == null) {
//                log.error("Unable to find config file");
            }
            config.load(input);
        } catch (Exception e){
//            log.error("Failed load configuration", e);
            throw new ExceptionInInitializerError();
        }
    }

    //MAC IOS FROM FILE
    private void initConfig() {
        platform = System.getProperty("platform", config.getProperty("platform"));
        runtimeEnv = System.getProperty("runtimeEnv", config.getProperty("runtimeEnv"));
        buildType = System.getProperty("buildType", config.getProperty("buildType"));
        platformVersion = System.getProperty("platformVersion", config.getProperty("platformVersion"));
        deviceName = System.getProperty("deviceName", config.getProperty("deviceName"));
        appiumUrl = System.getProperty("appiumURL", config.getProperty("appiumURL"));
    }



    private static Boolean isPlatform(String expectedPlatform) {
        return platform.equals(expectedPlatform);
    }

    public static Boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public static Boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }

    private static Boolean isRuntimeEnv(String expectedRuntimeEnv) {
        return runtimeEnv.equals(expectedRuntimeEnv);
    }

    public static String getRuntimeEnvVar() {
        return runtimeEnv;
    }

    public static String getAppiumUrlVar() {
        return appiumUrl;
    }

    public static String getBuildTypeVar() {
        return buildType;
    }

    public static String getPlatformVersionVar() {
        return platformVersion;
    }

    public static String getDeviceNameVar() {
        return deviceName;
    }

    public static Boolean isLocalHostRuntimeEnv() {
        return isRuntimeEnv(RUNTIME_ENV_LOCALHOST);
    }

    public static Boolean isWindowsRuntimeEnv() {
        return isRuntimeEnv(RUNTIME_ENV_WINDOWS);
    }

    public static Boolean isMacRuntimeEnv() {
        return isRuntimeEnv(RUNTIME_ENV_MAC);
    }


}
