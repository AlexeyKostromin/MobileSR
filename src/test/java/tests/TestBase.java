package tests;

import com.codeborne.selenide.Configuration;
import lib.DriverMobile;
import lib.Platform;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Platform.getInstance();
        initDriver();
    }

    @BeforeEach
    void beforeEach() {
        open();
    }

    @AfterEach
    void addAttachments() {

    }


    static void initDriver() {
        Configuration.browser = null;
        Configuration.browser = DriverMobile.class.getName();

        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }
}
