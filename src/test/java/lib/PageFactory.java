package lib;

import lib.ui.android.DashboardPageAndroid;
import lib.ui.android.GamesPageAndroid;
import lib.ui.android.LoginPageAndroid;
import lib.ui.ios.DashboardPageIOS;
import lib.ui.ios.GamesPageIOS;
import lib.ui.ios.LoginPageIOS;
import lib.ui.pages.DashboardPage;
import lib.ui.pages.GamesPage;
import lib.ui.pages.LoginPage;
import lib.ui.strategy.AndroidAppStrategy;
import lib.ui.strategy.IOSAppStrategy;

//import static lib.BasePage.driver;
import static lib.Platform.isAndroid;
import static lib.Platform.isIOS;

public class PageFactory {

    public static BasePage getBasePage() {
        if (isAndroid()) {
            return new BasePage(new AndroidAppStrategy());
        } else if (isIOS()) {
            return new BasePage(new IOSAppStrategy());
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

    public static LoginPage getLoginPage() {
        if (isAndroid()) {
            return new LoginPageAndroid(new AndroidAppStrategy());
        } else if (isIOS()) {
            return new LoginPageIOS(new IOSAppStrategy());
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

    public static DashboardPage getDashboardPage() {
        if (isAndroid()) {
            return new DashboardPageAndroid(new AndroidAppStrategy());
        } else if (isIOS()) {
            return new DashboardPageIOS(new IOSAppStrategy());
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

    public static GamesPage getGamesPage() {
        if (isAndroid()) {
            return new GamesPageAndroid(new AndroidAppStrategy());
        } else if (isIOS()) {
            return new GamesPageIOS(new IOSAppStrategy());
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

}
