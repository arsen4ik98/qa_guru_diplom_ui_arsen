package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
})
public interface WebDriverConfig extends Config{
    @Key("baseUrl")
    @DefaultValue("https://bellintegrator.ru/")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();
}