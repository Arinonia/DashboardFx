package fr.arinonia.dashboardfx.ui.controls;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

/**
 * @author Arinonia
 * Created at 09/12/2021 - 17:57
 **/
public class CircleButton extends GridPane {


    public CircleButton() {
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setVgrow(this, Priority.ALWAYS);
        this.setMaxSize(60.0D, 60.0D);
        this.setMinSize(60.0D, 60.0D);
        this.setStyle("-fx-background-color: #9D5B3E; -fx-background-radius: 50%;");
        this.setCursor(Cursor.HAND);

        final Label label = new Label("+");
        GridPane.setHgrow(label, Priority.ALWAYS);
        GridPane.setVgrow(label, Priority.ALWAYS);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setValignment(label, VPos.CENTER);
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-size: 56px;");
        label.setAlignment(Pos.CENTER);
        label.setTranslateY(-15.0D);
        this.getChildren().add(label);

        this.setOnMouseEntered(e ->  this.setStyle("-fx-background-color: #bb8066; -fx-background-radius: 50%;"));
        this.setOnMouseExited(e ->  this.setStyle("-fx-background-color: #9D5B3E; -fx-background-radius: 50%;"));
    }
}
