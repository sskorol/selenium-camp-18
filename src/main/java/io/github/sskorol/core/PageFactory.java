package io.github.sskorol.core;

import static org.joor.Reflect.on;

@SuppressWarnings("JavadocType")
public final class PageFactory {

    private PageFactory() {
        throw new UnsupportedOperationException("Illegal access to private constructor");
    }

    public static <T extends Page> T open(final Class<T> pageClass) {
        return at(pageClass).open();
    }

    public static <T extends Page> T at(final Class<T> pageClass) {
        return on(pageClass).create().get();
    }
}
