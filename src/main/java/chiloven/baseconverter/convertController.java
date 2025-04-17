package chiloven.baseconverter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kordamp.ikonli.fluentui.FluentUiRegularAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class convertController {
    private static final Logger logger = LogManager.getLogger(convertController.class);
    private final Map<Character, Button> buttonMap = new HashMap<>();
    @FXML
    private TextField inputField;
    @FXML
    private TextField fromField, toField;
    @FXML
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonA, buttonB, buttonC, buttonD, buttonE, buttonF;
    @FXML
    private Button buttonBackspace, buttonExchange, buttonEnter;
    @FXML
    private BorderPane borderPane;

    @FXML
    public void initialize() {
        buttonMap.put('0', button0);
        buttonMap.put('1', button1);
        buttonMap.put('2', button2);
        buttonMap.put('3', button3);
        buttonMap.put('4', button4);
        buttonMap.put('5', button5);
        buttonMap.put('6', button6);
        buttonMap.put('7', button7);
        buttonMap.put('8', button8);
        buttonMap.put('9', button9);
        buttonMap.put('A', buttonA);
        buttonMap.put('B', buttonB);
        buttonMap.put('C', buttonC);
        buttonMap.put('D', buttonD);
        buttonMap.put('E', buttonE);
        buttonMap.put('F', buttonF);

        // Apply GaussianBlur effect to BorderPane
        GaussianBlur blur = new GaussianBlur(40);
        borderPane.setEffect(blur);

        // Set icons to buttons using utility method
        buttonUtils.setButtonIcon(buttonBackspace, FluentUiRegularAL.BACKSPACE_20, 18);
        buttonUtils.setButtonIcon(buttonExchange, FluentUiRegularAL.ARROW_SWAP_20, 18);
        buttonUtils.setButtonIcon(buttonEnter, FluentUiRegularAL.ARROW_ENTER_24, 18);

        // Add listener for base field change
        fromField.textProperty().addListener((obs, oldVal, newVal) -> baseUtils.updateButtonsForBase(buttonMap, fromField.getText().trim()));
        baseUtils.updateButtonsForBase(buttonMap, fromField.getText().trim()); // Initial call
    }

    @FXML
    private void handleExchange() {
        String temp = fromField.getText();
        fromField.setText(toField.getText());
        toField.setText(temp);
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String currentText = inputField.getText();
        inputField.setText(currentText + clickedButton.getText());
    }

    @FXML
    private void handleClear() {
        inputField.clear();
    }

    @FXML
    private void handleBackspace() {
        String currentText = inputField.getText();
        if (!currentText.isEmpty()) {
            inputField.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    @FXML
    private void handleEnter() {
        if (Objects.equals(inputField.getText(), "")) {
            inputField.setText("0");
            return;
        }

        String fromText = fromField.getText();
        String toText = toField.getText();
        int fromBase, toBase;

        try {
            fromBase = Integer.parseInt(fromText);
            toBase = Integer.parseInt(toText);
            if (fromBase < 2 || fromBase > 16 || toBase < 2 || toBase > 16) {
                throw new NumberFormatException("Base needs to be between 2 and 16");
            }
        } catch (NumberFormatException e) {
            inputField.setText("0");
            alertModule.showAlert("Base Format Error", "Invalid bases, please enter an integer between 2 and 16!", Alert.AlertType.ERROR);
            logger.error("Base format error occurred", e);
            return;
        }

        String input = inputField.getText();
        String result = conversionUtils.convertBase(input, fromBase, toBase);
        inputField.setText(result);
    }

    @FXML
    private void handleClose() {
        Platform.exit();
    }

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Number Base Converter Application");
        alert.setContentText("Version 1.0\nDeveloped by Mackenzie\n© 2025");
        alert.showAndWait();
    }
}
