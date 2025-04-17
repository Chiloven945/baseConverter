package chiloven.baseconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class baseConverter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/converter.fxml"));
        Parent root = loader.load();
        stage.setTitle("Menu Application");
        // stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icon.png"))));
        stage.setScene(new Scene(root));
        stage.show();
    }
}