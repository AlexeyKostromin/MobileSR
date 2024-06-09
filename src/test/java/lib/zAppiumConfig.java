package lib;

import java.net.MalformedURLException;
import java.net.URL;

public class zAppiumConfig {

//    private static Map<String, URL> appiumUrls;
//
//    static {
//        appiumUrls = new HashMap<>();
//        appiumUrls.put("localhostEnv", createURL("http://127.0.0.1:4723/)"));
//        appiumUrls.put("windowsEnv", new URL("http://192.168.0.204:4723/");
//        appiumUrls.put("macEnv", new URL("http://192.168.0.202:4723/");
//    }

    private static URL createURL(String url) throws MalformedURLException {
        return new URL("http://127.0.0.1:4723/)");
    }
    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://" + "127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static URL getAppiumUrl(){
//        String environment = Platform.getInstance().getRuntimeEnvVar();
//        return appiumUrls.getOrDefault(environment, null);
//    }



}
