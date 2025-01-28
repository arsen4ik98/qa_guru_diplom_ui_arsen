import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
//import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
//import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.remote.DesiredCapabilities;
import testdata.Attach;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestsSoftportal {

    /*static CredentialsConfig config;

     */
    @BeforeAll
    static void beforeAll() {
        /*
        config = ConfigFactory.create(CredentialsConfig.class);
        String browserVersion = System.getProperty("version", "126.0");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("windowSize", "1920x1080");
        String remoteUrl = System.getProperty("remoteBrowserUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

         */
        Configuration.baseUrl = "https://www.softportal.com/";
        Configuration.pageLoadStrategy = "eager";
        /*Configuration.remote = remoteUrl;
        Configuration.browserVersion = browserVersion;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

        System.out.println("Remote URL: " + remoteUrl);
        System.out.println("Browser: " + Configuration.browser);
        System.out.println("Browser version: " + Configuration.browserVersion);
        System.out.println("Window size: " + Configuration.browserSize);

         */
    }

    /*@Test
    @Tag("softportal_test")
    void checkMainPageLoads() {
        step("Открыть главную страницу", () ->
                open("/")
        );
        step("Проверить наличие заголовка 'SoftPortal'", () ->
                $("#str").setValue("Google Chrome")
        );
        step("Кликнуть на кнопку 'Поиск'", () ->
                $("[alt='Искать']").click()
        );
        step("Кликнуть на кнопку 'Поиск'", () ->
                $$("a").filterBy(text("Google Chrome")).first()
        );
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        //System.out.println("Remote URL: " + config.remote());
    }

     */
    @Test
    void successfulSearchTest() {
        Configuration.pageLoadStrategy = "eager";

        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("ru.selenide.org"));
    }
}



