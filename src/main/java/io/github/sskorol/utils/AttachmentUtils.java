package io.github.sskorol.utils;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.addAttachment;

@SuppressWarnings("JavadocType")
public final class AttachmentUtils {

    private AttachmentUtils() {
        throw new UnsupportedOperationException("Illegal access to private constructor");
    }

    public static void attachScreenshot(final String name, final byte[] data) {
        addAttachment(name, new ByteArrayInputStream(data));
    }
}
