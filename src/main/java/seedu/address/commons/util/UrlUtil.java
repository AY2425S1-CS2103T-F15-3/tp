package seedu.address.commons.util;

import javafx.application.HostServices;

/**
 * Singleton utility class that contains an instance of HostServices from the JavaFX application.
 * @author sayomaki
 */
public class UrlUtil {
    /** Instance of host services **/
    private static HostServices hostServices;

    /**
     * Sets the HostServices instance from the JavaFX application
     * @param hostServices the HostServices instance of the application
     */
    public static void setHostServices(HostServices hostServices) {
        UrlUtil.hostServices = hostServices;
    }

    /**
     * Opens the requested URL with the default browser on the user's computer.
     * This does nothing if the host services instance is not yet setup.
     * @param url the url to open
     */
    public static void openUrl(String url) {
        if (hostServices == null) {
            return;
        }

        hostServices.showDocument(url);
    }
}
