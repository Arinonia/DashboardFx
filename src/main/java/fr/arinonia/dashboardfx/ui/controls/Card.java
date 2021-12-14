package fr.arinonia.dashboardfx.ui.controls;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.layout.*;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 23:20
 **/
public class Card extends GridPane {

    protected final GridPane mainPane = new GridPane();
    private boolean toggle = false;

    public Card() {
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setHalignment(this, HPos.CENTER);
        this.setMinSize(900.0D, 60.0D);
        this.setMaxWidth(900.0D);
        this.setCursor(Cursor.HAND);

        final VBox vBox = new VBox();
        GridPane.setHgrow(vBox, Priority.ALWAYS);
        GridPane.setVgrow(vBox, Priority.ALWAYS);
        GridPane.setHalignment(vBox, HPos.CENTER);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setMaxWidth(900.0D);
        vBox.setMinWidth(900.0D);
        vBox.setMinHeight(60.0D);
        this.getChildren().add(vBox);


        this.mainPane.setMinWidth(900);
        this.mainPane.setMinHeight(60);
        this.mainPane.setStyle("-fx-background-color: rgb(30, 32, 34); -fx-background-radius: 30px;");
        vBox.getChildren().add(this.mainPane);

        final GridPane infosPane = new GridPane();
        GridPane.setHalignment(infosPane, HPos.CENTER);
        infosPane.setMinHeight(120);
        infosPane.setMinWidth(800);
        infosPane.setMaxHeight(120);
        infosPane.setMaxWidth(800);
        infosPane.setStyle("-fx-background-color: rgba(30, 32, 34, 0.56); -fx-background-radius: 0px 0px 30px 30px;");

        this.setOnMouseClicked(e -> {
            if (!this.toggle) {
                vBox.getChildren().add(infosPane);
            } else {
                vBox.getChildren().remove(infosPane);
            }
            this.toggle = !this.toggle;
        });
    }
}
