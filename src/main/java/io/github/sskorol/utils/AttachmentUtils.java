package io.github.sskorol.utils;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.addAttachment;

public class AttachmentUtils {

    public static void attachScreenshot(final String name, final byte[] data) {
        addAttachment(name, new ByteArrayInputStream(data));
    }
}
