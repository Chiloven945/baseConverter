package chiloven.baseconverter;

import javafx.scene.control.Alert;

public class alertModule {

    /**
     *
     * Demonstrate a alert.
     *
     * @param title Title of the alert
     * @param message Message of the alert
     * @param type Type of the alert
     */
    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
