package lib;

import lib.ui.player.PlayerAndroid;
import lib.ui.player.PlayerIOS;
import lib.ui.android.DashboardPageAndroid;
import lib.ui.android.GamesPageAndroid;
import lib.ui.android.LoginPageAndroid;
import lib.ui.ios.DashboardPageIOS;
import lib.ui.ios.GamesPageIOS;
import lib.ui.ios.LoginPageIOS;
import lib.ui.pages.DashboardPage;
import lib.ui.pages.GamesPage;
import lib.ui.pages.LoginPage;

import static lib.Platform.isAndroid;
import static lib.Platform.isIOS;

public class PageFactory {

//    public static PlatformActions getBasePage() {
//        if (isAndroid()) {
//            return new PlatformActions(this);
//        } else if (isIOS()) {
//            return new PlatformActions(this);
//        } else {
//            throw new IllegalStateException("Unsupported platform");
//        }
//    }

    public static LoginPage getLoginPage() {
        if (isAndroid()) {
            return new LoginPageAndroid();
        } else if (isIOS()) {
            return new LoginPageIOS();
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

    public static DashboardPage getDashboardPage() {
        if (isAndroid()) {
            return new DashboardPageAndroid();
        } else if (isIOS()) {
            return new DashboardPageIOS();
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

    public static GamesPage getGamesPage() {
        if (isAndroid()) {
            return new GamesPageAndroid(new PlayerAndroid());
        } else if (isIOS()) {
            return new GamesPageIOS(new PlayerIOS());
        } else {
            throw new IllegalStateException("Unsupported platform");
        }
    }

}
