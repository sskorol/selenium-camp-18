package io.github.sskorol.core;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;

@SuppressWarnings("JavadocType")
@Config.Sources("classpath:app.properties")
public interface BaseConfig extends Config {

    BaseConfig BASE_CONFIG = ConfigCache.getOrCreate(BaseConfig.class, System.getenv(), System.getProperties());

    @Key("app.url")
    String appUrl();

    @Key("APP_CONTAINER_NAME")
    @DefaultValue("sc18_react-app_1:react-app")
    String appContainerName();
}
