package mobile.configs;

public class Platform {
    private static String PLATFORM;
    private static String RUNTIME_ENV;
    private static String APPIUM_URL;
    private final static String PLATFORM_ANDROID = "android";
    private final static String PLATFORM_IOS = "ios";
    private static String BUILD_TYPE;
    private static String PLATFORM_VERSION;
    private static String DEVICE_NAME;
    private final static String RUNTIME_ENV_LOCALHOST = "localHostRuntimeEnv";
    private final static String RUNTIME_ENV_WINDOWS = "windowsRuntimeEnv";
    private final static String RUNTIME_ENV_MAC = "macRuntimeEnv";
    private final static String MAC_APPIUM_URL = "http://192.168.0.202:4723/";

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

    //WINDOWS ANDROID
    private void initConfig() {
        PLATFORM = System.getProperty("platform", PLATFORM_ANDROID);
        RUNTIME_ENV = System.getProperty("runtimeEnv", RUNTIME_ENV_LOCALHOST);
        BUILD_TYPE = System.getProperty("buildType", "live");
        PLATFORM_VERSION = System.getProperty("platformVersion", "13.0");
        DEVICE_NAME = System.getProperty("deviceName", "Pixel7");
        APPIUM_URL = System.getProperty("appiumURL", "http://127.0.0.1:4723/");
    }

    //MAC IOS
//    private void initConfig() {
//        PLATFORM = System.getProperty("platform", PLATFORM_IOS);
//        RUNTIME_ENV = System.getProperty("runtimeEnv", RUNTIME_ENV_MAC);
//        BUILD_TYPE = System.getProperty("buildType", "staring");
//        PLATFORM_VERSION = System.getProperty("platformVersion", "17.5");
//        DEVICE_NAME = System.getProperty("deviceName", "iPhone 15");
//        APPIUM_URL = System.getProperty("appiumURL", "http://192.168.0.200:4723/");
////        APPIUM_URL = System.getProperty("appiumURL", "http://10.17.141.230:4723/");
//    }

    //MAC ANDROID
//    private void initConfig() {
//        PLATFORM = System.getProperty("platform", PLATFORM_ANDROID);
//        RUNTIME_ENV = System.getProperty("runtimeEnv", RUNTIME_ENV_MAC);
//        BUILD_TYPE = System.getProperty("buildType", "live");
//        PLATFORM_VERSION = System.getProperty("platformVersion", "14.0");
//        DEVICE_NAME = System.getProperty("deviceName", "Pixel7");
//        APPIUM_URL = System.getProperty("appiumURL", "http://192.168.0.200:4723/");
////        APPIUM_URL = System.getProperty("appiumURL", "http://10.17.141.230:4723/");
//    }




    private static Boolean isPlatform(String expectedPlatform) {
        return PLATFORM.equals(expectedPlatform);
    }

    public static Boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    public static Boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }

    private static Boolean isRuntimeEnv(String expectedRuntimeEnv) {
        return RUNTIME_ENV.equals(expectedRuntimeEnv);
    }

    public static String getRuntimeEnvVar() {
        return RUNTIME_ENV;
    }

    public static String getAppiumUrlVar() {
        return APPIUM_URL;
    }

    public static String getBuildTypeVar() {
        return BUILD_TYPE;
    }

    public static String getPlatformVersionVar() {
        return PLATFORM_VERSION;
    }

    public static String getDeviceNameVar() {
        return DEVICE_NAME;
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
