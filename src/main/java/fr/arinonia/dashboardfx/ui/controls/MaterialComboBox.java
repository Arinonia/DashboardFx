package fr.arinonia.dashboardfx.ui.controls;

import com.jfoenix.controls.JFXComboBox;
import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.utils.Constants;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * @author Arinonia
 * Created at 10/12/2021 - 02:36
 **/
public class MaterialComboBox extends JFXComboBox<String> {

    public MaterialComboBox() {
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setVgrow(this, Priority.ALWAYS);
        this.getStylesheets().add(Main.class.getResource("/css/combobox.css").toExternalForm());
        this.setStyle("-jfx-focus-color: #"  + Constants.PURPLE + "; -jfx-unfocus-color: rgba(0, 0, 0, 0); -fx-font-family: Inconsolata;");


    }
}
