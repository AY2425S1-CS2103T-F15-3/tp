package seedu.address.commons.util;

import javafx.application.HostServices;

public class UrlUtil {
    private static HostServices hostServices;

    public static void setHostServices(HostServices hostServices) {
        UrlUtil.hostServices = hostServices;
    }

    public static void openUrl(String url) {
        if (hostServices == null) {
            return;
        }

        hostServices.showDocument(url);
    }
}
