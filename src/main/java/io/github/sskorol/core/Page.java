package io.github.sskorol.core;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;

@SuppressWarnings("JavadocType")
public interface Page {

    <T extends Page> T open(String url);

    default <T extends Page> T open() {
        return open(url());
    }

    default String url() {
        return BASE_CONFIG.appUrl();
    }
}
