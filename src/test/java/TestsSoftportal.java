import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import testdata.Attach;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestsSoftportal {

    static CredentialsConfig config;


    @BeforeAll
    static void beforeAll() {

        config = ConfigFactory.create(CredentialsConfig.class);
        String browserVersion = System.getProperty("version", "126.0");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("windowSize", "1920x1080");
        String remoteUrl = System.getProperty("remoteBrowserUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");


        Configuration.baseUrl = "https://www.softportal.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = remoteUrl;
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


    }

    @Test
    @Tag("softportal_test")
    void checkSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () ->
                open("/")
        );
        Configuration.timeout=10000;
            step("Убрать Баннер", () ->
                    $(".fc-button-label").click()
            );

        step("Проверить наличие заголовка 'SoftPortal'", () ->
                $("#str").setValue("Google Chrome")
        );
        step("Кликнуть на кнопку 'Поиск'", () ->
                $("[alt='Искать']").click()
        );
        step("Поиск корректной проверки'", () ->
                $(".searchResults").shouldHave(text("Google Chrome – один из самых популярных браузеров"))
        );
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        System.out.println("Remote URL: " + config.remote());
        closeWebDriver();
    }

    @Test
    @Tag("softportal_test")
    void checkCategoryAndroid() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () ->
                open("/")
        );
        Configuration.timeout=10000;
        step("Убрать Баннер", () ->
                $(".fc-button-label").click()
        );
        step("Перейти на категорию 'Android'", () ->
                $$(".geo18").findBy(text("Android")).click()
        );
        step("Поиск корректной проверки'", () ->
                $(".titleH geo18").shouldHave(text("Программы для Android"))
        );
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        System.out.println("Remote URL: " + config.remote());
        closeWebDriver();
    }

    @Test
    @Tag("softportal_test")
    void checkPopularSize() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () ->
                open("/")
        );
        Configuration.timeout=10000;
            step("Убрать Баннер", () ->
                    $(".fc-button-label").click()
            );

        step("Поиск корректной проверки'", () ->
                $$("div.rightContainerLinks > div").shouldHave(size(20), Duration.ofSeconds(10))
        );
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        System.out.println("Remote URL: " + config.remote());
        closeWebDriver();
    }






}



