package lib.ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.openqa.selenium.By.xpath;

public class LoginPage {
    public SelenideElement
            PERMISSION_ALLOW_BTN = $(id("com.android.permissioncontroller:id/permission_allow_button")),
            UPDATE_INSTALL = $(xpath("//android.widget.Button[@text='INSTALL']")),
            UPDATE_LATER = $(xpath("//android.widget.Button[@text='LATER']")),
            LOGIN_BTN = $(id("login-button")),
            USER_NAME_TEXT_BOX = $(id("Username")),
            PASSWORD_TEXT_BOX = $(id("Password")),
            LOGIN_FORM_BTN = $(xpath("//*[@text='Login']"));


    public void allowPermissions() {
        if (PERMISSION_ALLOW_BTN.exists()) {
            try {
                PERMISSION_ALLOW_BTN.click();
            } catch (Exception e) {
                System.err.println("Failed to click the allow permissions button");
                e.printStackTrace();
            }
        } else {
            System.out.println("There was no allow permissions dialog");
        }

    }

    public void updateLater() {
        UPDATE_LATER.click();
    }

    public void updateInstall() {
        UPDATE_INSTALL.click();
    }

    public void loginWithCredentials(String userName, String password) {
        LOGIN_BTN.click();
        USER_NAME_TEXT_BOX.click();
        USER_NAME_TEXT_BOX.sendKeys(userName);
        PASSWORD_TEXT_BOX.click();
        PASSWORD_TEXT_BOX.sendKeys(password);
        LOGIN_FORM_BTN.click();
    }
}
