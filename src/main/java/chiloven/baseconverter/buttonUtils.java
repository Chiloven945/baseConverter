package chiloven.baseconverter;

import javafx.scene.control.Button;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.javafx.FontIcon;

public class buttonUtils {

    // 设置按钮图标
    public static void setButtonIcon(Button button, Ikon icon, int size) {
        FontIcon fontIcon = new FontIcon(icon);
        fontIcon.setIconSize(size);
        button.setGraphic(fontIcon);
    }
}
