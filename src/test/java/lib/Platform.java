package lib;

import com.codeborne.selenide.Configuration;

public class Platform {
    private static String PLATFORM;
    private static String RUNTIME_ENV;
    private static String APPIUM_URL;
    private final static String PLATFORM_ANDROID = "android";
    private final static String PLATFORM_IOS = "ios";
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

    private void initConfig() {
        PLATFORM = System.getProperty("platform", PLATFORM_ANDROID);
        RUNTIME_ENV = System.getProperty("runtimeEnv", RUNTIME_ENV_LOCALHOST);
        APPIUM_URL = System.getProperty("appiumURL", "http://127.0.0.1:4723/");

    }

//    private String setAppiumUrl() {
//        if (isWindowsRuntimeEnv()) {
//            APPIUM_URL = WINDOWS_APPIUM_URL;
//        } else if (isMacRuntimeEnv()) {
//            APPIUM_URL = MAC_APPIUM_URL;
//        } else if (isLocalHostRuntimeEnv()) {
//            APPIUM_URL = LOCALHOST_APPIUM_URL;
//        }
//    }
//    public static URL getAppiumUrl() throws MalformedURLException {
//        if (Platform.getInstance().isLocalHostRuntimeEnv()) {
//            return new URL("http://127.0.0.1:4723/");
//        } else if (Platform.getInstance().isWindowsRuntimeEnv()) {
//            return new URL("http://192.168.0.204:4723/");
//        } else if (Platform.getInstance().isMacRuntimeEnv()) {
//            return new URL("http://192.168.0.202:4723/");
//        } else {
//            throw new IllegalStateException("Unsupported runtime environment.");
//        }
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
