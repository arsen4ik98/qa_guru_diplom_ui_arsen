package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties",
        "classpath:local.properties"
})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://bellintegrator.ru/")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("128.0")
    String browserVersion();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}