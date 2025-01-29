import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import testdata.Attach;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestsSoftportal {

    static CredentialsConfig config;
    static ExecutorService executor;

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
        Configuration.timeout = 10000;

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

        // Запускаем фоновый поток для автоматического закрытия баннера
        executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    closeBannerIfPresent();
                    Thread.sleep(2000); // Проверять каждые 2 секунды
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    @AfterAll
    static void tearDown() {
        if (executor != null) {
            executor.shutdownNow(); // Останавливаем поток после тестов
        }
        closeWebDriver();
    }

    public static void closeBannerIfPresent() {
        try {
            if ($(".fc-button-label").isDisplayed()) {
                $(".fc-button-label").click();
                System.out.println("Баннер закрыт.");
            }
        } catch (Exception e) {
            // Баннер отсутствует — продолжаем тест
        }
    }

    @Test
    @Tag("softportal_test")
    void checkSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () ->
                open("/")
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
    }

    @Test
    @Tag("softportal_test")
    void checkCategoryAndroid() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () ->
                open("/")
        );

        step("Перейти на категорию 'Android'", () ->
                $$(".TdLCatTitle").findBy(text("Android")).click()
        );
        step("Поиск корректной проверки'", () ->
                $(".geo18").shouldHave(text("Программы для Android"))
        );
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        System.out.println("Remote URL: " + config.remote());
    }

    @Test
    @Tag("softportal_test")
    void checkPopularSize() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть главную страницу", () ->
                open("/")
        );

        step("Поиск корректной проверки'", () ->
                $$("div.rightContainerLinks > div").shouldHave(size(20), Duration.ofSeconds(10))
        );
        Attach.addVideo();
        Attach.makeScreenshot();
        Attach.pageSource();
        Attach.browserConsoleLogs();
        System.out.println("Remote URL: " + config.remote());
    }
}
