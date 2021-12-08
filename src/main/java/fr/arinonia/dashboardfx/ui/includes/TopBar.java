package fr.arinonia.dashboardfx.ui.includes;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.panel.IPanel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

/**
 * @author Arinonia
 * Created at 07/12/2021 - 23:57
 **/
public class TopBar implements IPanel {

    private final PanelManager panelManager;
    private final GridPane layout;

    private double xOffset = 0.0D;
    private double yOffset = 0.0D;

    public TopBar(final PanelManager panelManager) {
        this.panelManager = panelManager;
        this.layout = new GridPane();

        GridPane.setHgrow(this.layout, Priority.ALWAYS);
        GridPane.setVgrow(this.layout, Priority.ALWAYS);

        this.layout.setOnMousePressed(e -> {
            this.xOffset = this.panelManager.getStage().getX() - e.getScreenX();
            this.yOffset = this.panelManager.getStage().getY() - e.getScreenY();
        });

        this.layout.setOnMouseDragged(e -> {
            this.panelManager.getStage().setX(e.getScreenX() + this.xOffset);
            this.panelManager.getStage().setY(e.getScreenY() + this.yOffset);
        });
        this.setupUi();
    }

    private void setupUi() {
        this.layout.setStyle("-fx-background-color: rgba(30,30,30,0.89);");
        final GridPane iconButton = new GridPane();
        GridPane.setHgrow(iconButton, Priority.ALWAYS);
        GridPane.setVgrow(iconButton, Priority.ALWAYS);
        GridPane.setHalignment(iconButton, HPos.RIGHT);
        iconButton.setMaxWidth(150.0D);
        this.layout.getChildren().add(iconButton);
        this.setupIcon(iconButton);
    }

    private void setupIcon(final GridPane layout) {
        final MaterialDesignIconView closeIcon = new MaterialDesignIconView(MaterialDesignIcon.CLOSE);
        GridPane.setVgrow(closeIcon, Priority.ALWAYS);
        GridPane.setHgrow(closeIcon, Priority.ALWAYS);
        GridPane.setHalignment(closeIcon, HPos.RIGHT);
        GridPane.setValignment(closeIcon, VPos.CENTER);
        closeIcon.setStyle("-fx-font-size: 22px;");
        closeIcon.setFill(Color.rgb(200, 200, 200));
        closeIcon.setTranslateX(-5.0D);
        closeIcon.setCursor(Cursor.HAND);
        closeIcon.setOnMouseEntered(e -> {
            closeIcon.setFill(Color.rgb(255, 255, 255));
        });
        closeIcon.setOnMouseExited(e -> {
            closeIcon.setFill(Color.rgb(200, 200, 200));
        });
        closeIcon.setOnMouseClicked(e -> System.exit(0));
        layout.getChildren().add(closeIcon);

        final MaterialDesignIconView fullScreenIcon = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MAXIMIZE);
        GridPane.setVgrow(fullScreenIcon, Priority.ALWAYS);
        GridPane.setHgrow(fullScreenIcon, Priority.ALWAYS);
        GridPane.setHalignment(fullScreenIcon, HPos.RIGHT);
        GridPane.setValignment(fullScreenIcon, VPos.CENTER);
        fullScreenIcon.setStyle("-fx-font-size: 22px;");
        fullScreenIcon.setFill(Color.rgb(200, 200, 200));
        fullScreenIcon.setTranslateX(-35.0D);
        fullScreenIcon.setCursor(Cursor.HAND);
        fullScreenIcon.setOnMouseEntered(e -> {
            fullScreenIcon.setFill(Color.rgb(255, 255, 255));
        });
        fullScreenIcon.setOnMouseExited(e -> {
            fullScreenIcon.setFill(Color.rgb(200, 200, 200));
        });
        fullScreenIcon.setOnMouseClicked(e -> this.panelManager.getStage().setMaximized(!this.panelManager.getStage().isMaximized()));
        layout.getChildren().add(fullScreenIcon);

        final MaterialDesignIconView minimizeIcon = new MaterialDesignIconView(MaterialDesignIcon.WINDOW_MINIMIZE);
        GridPane.setVgrow(minimizeIcon, Priority.ALWAYS);
        GridPane.setHgrow(minimizeIcon, Priority.ALWAYS);
        GridPane.setHalignment(minimizeIcon, HPos.RIGHT);
        GridPane.setValignment(minimizeIcon, VPos.CENTER);
        minimizeIcon.setStyle("-fx-font-size: 22px;");
        minimizeIcon.setFill(Color.rgb(200, 200, 200));
        minimizeIcon.setTranslateX(-65.0D);
        minimizeIcon.setCursor(Cursor.HAND);
        minimizeIcon.setOnMouseEntered(e -> {
            minimizeIcon.setFill(Color.rgb(255, 255, 255));
        });
        minimizeIcon.setOnMouseExited(e -> {
            minimizeIcon.setFill(Color.rgb(200, 200, 200));
        });
        minimizeIcon.setOnMouseClicked(e -> this.panelManager.getStage().setIconified(true));
        layout.getChildren().add(minimizeIcon);
    }


    @Override
    public PanelManager getPanelManager() {
        return this.panelManager;
    }

    @Override
    public void init(PanelManager panelManager) {}

    @Override
    public GridPane getLayout() {
        return this.layout;
    }

}
