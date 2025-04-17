package chiloven.baseconverter;

import javafx.scene.control.Button;

import java.util.Map;

public class baseUtils {

    // 更新按钮状态，根据输入的进制
    public static void updateButtonsForBase(Map<Character, Button> buttonMap, String baseText) {
        int base;
        try {
            base = Integer.parseInt(baseText);
        } catch (NumberFormatException e) {
            disableAllButtons(buttonMap);
            return;
        }

        if (base < 2 || base > 16) {
            disableAllButtons(buttonMap);
            return;
        }

        // 更新每个按钮的状态
        for (Map.Entry<Character, Button> entry : buttonMap.entrySet()) {
            char ch = entry.getKey();
            int value = Character.digit(ch, 16); // Support 0-9 and A-F, -1 if exceeded
            entry.getValue().setDisable(value < 0 || value >= base);
        }
    }

    // 禁用所有按钮
    private static void disableAllButtons(Map<Character, Button> buttonMap) {
        for (Button button : buttonMap.values()) {
            button.setDisable(true);
        }
    }
}
