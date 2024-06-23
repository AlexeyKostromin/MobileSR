package mobile.ui.pages;

import com.codeborne.selenide.SelenideElement;
import mobile.ui.base.BasePage;
import mobile.factory.PageFactory;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage extends BasePage {
    protected SelenideElement
            PERMISSION_ALLOW_BTN,
            CHROME_WELCOME_PAGE,
            CHROME_USE_WITHOUT_ACCOUNT_BTN,
            CHROME_ACCEPT_AND_CONTINUE_BTN,
            CHROME_NO_THANKS_BTN,
            UPDATE_DIALOG,
            UPDATE_INSTALL,
            UPDATE_LATER,
            UPDATE_CONTINUE,
            USER_NAME_TEXT_BOX,
            PASSWORD_TEXT_BOX,
            LOGIN_BTN,
            LOGIN_FORM_BTN,
            VERSION;

    public LoginPage() {

    }


    protected String getCurrentVersion() {
        return null;
    }

    public DashboardPage loginWithCredentials(String userName, String password) {
        LOGIN_BTN.shouldBe(visible).click();
        chromeOptionSelectIfDisplayed();
        USER_NAME_TEXT_BOX.shouldBe(visible).click();
        USER_NAME_TEXT_BOX.sendKeys(userName);
        PASSWORD_TEXT_BOX.click();
        PASSWORD_TEXT_BOX.sendKeys(password);
        LOGIN_FORM_BTN.click();
        return PageFactory.getDashboardPage();
    }

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

    public void updateApp() {
//        var currentVersion = getCurrentVersion();
        Boolean isUpdateDialogDisplays = waitForElementIfExist(UPDATE_DIALOG, 5);

        if (isUpdateDialogDisplays) {
            if (UPDATE_CONTINUE.isDisplayed()) {
                updateContinue();
            } else if (UPDATE_INSTALL.isDisplayed()) {
                updateInstall();
                platformActions.closeAppFromAppSwitch();
                platformActions.activateApp();
            }
//            var newVersion = getCurrentVersion();
        }
    }


    private void updateContinue() {
//        var currentVersion = getCurrentVersion();
        var newVersion = "";

        if (UPDATE_CONTINUE.isDisplayed()) {
            UPDATE_CONTINUE.click();
//            while (currentVersion.equals(newVersion)){
//                newVersion= getCurrentVersion();
//
//            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) { /* Do nothing */ } //TODO:add reliable wait for update completed
        }
    }

//    private void updateContinue() {
//        if (UPDATE_CONTINUE.isDisplayed()) {
//            UPDATE_CONTINUE.click();
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) { /* Do nothing */ } //TODO:add reliable wait for update completed
//        }
//    }


    private Boolean updateInstall() {
        int maxAttempts = 3;
        int attempts = 0;
        boolean isInstallSelected = false;

        while (attempts <= maxAttempts) {
            try {
                if (UPDATE_DIALOG.isDisplayed()) {
                    UPDATE_INSTALL.click();
                    isInstallSelected = true;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) { /* Do nothing */ } //TODO:add reliable wait for update downloaded
                    break;
                } else if (LOGIN_BTN.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {
                attempts++;
                System.err.println("Failed to submit update option or find login bnt. Retrying... attempt " + attempts);
            }
        }
        if (isInstallSelected) {
            return true;
        } else {
            throw new RuntimeException("Failed to submit update option or find login bnt. Tried with attempts " + attempts);
        }
    }

    private void updateLaterSelect() {
        if (UPDATE_DIALOG.isDisplayed()) {
            UPDATE_LATER.click();
        }
    }

    public void updateLater() {
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts <= maxAttempts) {
            try {
                if (UPDATE_DIALOG.isDisplayed()) {
                    updateLaterSelect();
                    return;
                } else if (LOGIN_BTN.isDisplayed()) {
                    return;
                }
            } catch (Exception e) {
                attempts++;
                System.err.println("Failed to submit update option or find login bnt. Retrying... attempt " + attempts);
            }
        }
        throw new RuntimeException("Failed to submit update option or find login bnt. Tried with attempts " + attempts);
    }


    public void chromeOptionSelectIfDisplayed() {
        int attempts = 0;

        while (true) {
            try {
                if (USER_NAME_TEXT_BOX.isDisplayed()) {
                    return;
                } else if (CHROME_WELCOME_PAGE.isDisplayed()) {
                    chromeAcceptTerms();
                    return;
                }
            } catch (Exception e) {
                attempts++;
                System.err.println("Failed to submit chromeUseWithoutAccount option or find login form. Retrying... attempt " + attempts);
                if (attempts >= 3) {
                    throw new RuntimeException("Failed to submit chromeUseWithoutAccount option or find login form. Tried with attempts " + attempts);
                }
            }
        }
    }


    private void chromeAcceptTerms() {
        if (CHROME_USE_WITHOUT_ACCOUNT_BTN.isDisplayed()) {
            chromeUseWithoutAccountSelect();
        } else if (CHROME_ACCEPT_AND_CONTINUE_BTN.isDisplayed()) {
            chromeAcceptAndContinueSelect();
        }
    }

    private void chromeUseWithoutAccountSelect() {
        try {
            CHROME_USE_WITHOUT_ACCOUNT_BTN.click();
        } catch (Exception e) {
            System.err.println("Failed to click the 'Use without an account' button");
            e.printStackTrace();
        }
    }

    private void chromeAcceptAndContinueSelect() {
        try {
            CHROME_ACCEPT_AND_CONTINUE_BTN.click();
            CHROME_NO_THANKS_BTN.shouldBe(visible).click();
        } catch (Exception e) {
            System.err.println("Failed to click the 'Accept and Continue' button");
            e.printStackTrace();
        }
    }


}
