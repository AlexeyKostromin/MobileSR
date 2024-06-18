package lib.ui.android;

import lib.ui.pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class LoginPageAndroid extends LoginPage {

    public LoginPageAndroid() {
        initElements();
    }

    protected void initElements() {
        PERMISSION_ALLOW_BTN = $(id("com.android.permissioncontroller:id/permission_allow_button"));
        CHROME_WELCOME_PAGE = $(id("com.android.chrome:id/fre_pager"));
        CHROME_USE_WITHOUT_ACCOUNT_BTN = $(id("com.android.chrome:id/signin_fre_dismiss_button"));
        UPDATE_DIALOG = $(xpath("//android.widget.TextView[@text='Update available']"));
        UPDATE_INSTALL = $(xpath("//android.widget.Button[@text='INSTALL']"));
        UPDATE_LATER = $(xpath("//android.widget.Button[@text='LATER']"));
        UPDATE_CONTINUE = $(id(""));
        LOGIN_BTN = $(id("login-button"));
        USER_NAME_TEXT_BOX = $(id("Username"));
        PASSWORD_TEXT_BOX = $(id("Password"));
        LOGIN_FORM_BTN = $(xpath("//*[@text='Login']"));
    }
}
