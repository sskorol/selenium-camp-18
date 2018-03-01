package io.github.sskorol.core;

import io.github.sskorol.config.XmlConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;

@SuppressWarnings("JavadocType")
public class Chrome implements Browser {

    public Name name() {
        return Name.Chrome;
    }

    public boolean isRemote() {
        return true;
    }

    public Capabilities configuration(final XmlConfig config) {
        final ChromeOptions options = new ChromeOptions();
        options.setCapability("applicationContainers", BASE_CONFIG.appContainerName());
        return merge(config, options);
    }
}
