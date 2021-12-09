package fr.arinonia.dashboardfx.ui.controls;

import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.ui.panel.IPanel;
import fr.arinonia.dashboardfx.ui.panels.RootPanel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Objects;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 00:53
 **/
public class BarButton extends GridPane {

    private final Label textLabel;

    public BarButton(final String text, boolean isCurrent) {

        GridPane.setVgrow(this, Priority.ALWAYS);
        GridPane.setHgrow(this, Priority.ALWAYS);
        GridPane.setHalignment(this, HPos.CENTER);

        this.setMaxSize(200.0D, 40.0D);
        this.setMinSize(200.0D, 40.0D);

        this.setStyle("-fx-background-color: rgba(38,38,38, 0.6); -fx-background-radius: 20px");

        final Image icon = new Image(Objects.requireNonNull(Main.class.getResource("/images/icons/" + text.toLowerCase() + ".png"), "Can't find the resource !").toExternalForm());
        final ImageView iconView = new ImageView(icon);
        GridPane.setVgrow(iconView, Priority.ALWAYS);
        GridPane.setHgrow(iconView, Priority.ALWAYS);
        GridPane.setValignment(iconView, VPos.CENTER);
        GridPane.setHalignment(iconView, HPos.LEFT);
        iconView.setTranslateX(20.0D);
        iconView.setFitHeight(22.0D);
        iconView.setFitWidth(22.0D);
        this.getChildren().add(iconView);

        this.textLabel = new Label(text);
        GridPane.setVgrow(textLabel, Priority.ALWAYS);
        GridPane.setHgrow(textLabel, Priority.ALWAYS);
        GridPane.setValignment(textLabel, VPos.CENTER);
        GridPane.setHalignment(textLabel, HPos.LEFT);
        textLabel.setTextFill(Color.WHITE);
        textLabel.setStyle("-fx-font-size: 18px;");
        textLabel.setTranslateX(50.0D);
        this.getChildren().add(textLabel);

        this.setOnMouseEntered(e -> {
            this.setStyle("-fx-background-color: rgb(87,87,87); -fx-background-radius: 15px");
        });

        this.setOnMouseExited(e -> {
            this.setStyle("-fx-background-color: rgba(38,38,38, 0.6); -fx-background-radius: 15px");
        });

        this.setCursor(Cursor.HAND);

        if (isCurrent) {
            textLabel.setTextFill(Color.WHITE);
        } else {
            textLabel.setTextFill(Color.rgb(150, 150, 150));
        }
    }

    public BarButton(String text) {
        this(text, false);
    }

    public void setOnClick(final IPanel panel, final List<BarButton> buttons, final RootPanel rootPanel) {
        this.setOnMouseClicked(e -> {
            for (BarButton instanceButton : buttons) {
                instanceButton.textLabel.setTextFill(Color.rgb(150, 150, 150));
            }
            this.textLabel.setTextFill(Color.WHITE);
            rootPanel.getPanelManager().showPanel(rootPanel.getCenterPanel(), panel);
        });
    }
}
