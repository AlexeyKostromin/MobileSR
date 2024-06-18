package lib.ui.ios;

import lib.ui.pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class LoginPageIOS extends LoginPage {

    public LoginPageIOS() {
        initElements();
    }

    protected void initElements() {
        PERMISSION_ALLOW_BTN = $(id("x"));
        CHROME_WELCOME_PAGE = $(id("x"));
        CHROME_USE_WITHOUT_ACCOUNT_BTN = $(id("x"));
        UPDATE_DIALOG = $(xpath("//XCUIElementTypeAlert"));
        UPDATE_INSTALL = $(xpath("x"));
        UPDATE_LATER = $(xpath("x"));
        UPDATE_CONTINUE = $(id("Continue"));
        LOGIN_BTN = $(id("login-button"));
        USER_NAME_TEXT_BOX = $(xpath("//XCUIElementTypeTextField[@value='Username']"));
        PASSWORD_TEXT_BOX = $(xpath("//XCUIElementTypeSecureTextField[@value='Password']"));
        LOGIN_FORM_BTN = $(id("Login"));
    }
}
