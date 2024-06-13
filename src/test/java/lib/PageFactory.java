package lib;

import lib.ui.strategy.AndroidAppStrategy;
import lib.ui.strategy.IOSAppStrategy;
import org.openqa.selenium.remote.RemoteWebDriver;

//import static lib.BasePage.driver;
import static lib.Platform.isAndroid;
import static lib.Platform.isIOS;

public class PageFactory {

//    public static BasePage getBasePage() {
//        if (isAndroid()) {
//            return new BasePage(new AndroidAppStrategy());
//        } else if (isIOS()) {
//            return new BasePage(new IOSAppStrategy());
//        } else {
//            throw new IllegalStateException("Unsupported platform");
//        }
//    }

}
