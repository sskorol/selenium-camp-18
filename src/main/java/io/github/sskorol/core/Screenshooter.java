package io.github.sskorol.core;

import org.testng.ITestResult;

import static io.github.sskorol.utils.AttachmentUtils.attachScreenshot;
import static java.util.Objects.nonNull;

@SuppressWarnings("JavadocType")
public class Screenshooter implements ScreenshotConsumer {

    @Override
    public void handle(final byte[] screenshot, final ITestResult testResult) {
        if (nonNull(screenshot) && screenshot.length > 0) {
            attachScreenshot("Screenshot", screenshot);
        }
    }
}
