package chiloven.baseconverter;

import javafx.scene.control.Button;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.javafx.FontIcon;

public class buttonUtils {

    /**
     *
     * Set an icon for a button.
     *
     * @param button Button's ID
     * @param icon Icon will be used
     * @param size Size of the icon
     */
    public static void setButtonIcon(Button button, Ikon icon, int size) {
        FontIcon fontIcon = new FontIcon(icon);
        fontIcon.setIconSize(size);
        button.setGraphic(fontIcon);
    }
}
