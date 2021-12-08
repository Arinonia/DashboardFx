package fr.arinonia.dashboardfx.ui;

import fr.arinonia.dashboardfx.DashBoard;
import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.ui.panel.IPanel;
import fr.arinonia.dashboardfx.ui.panel.Panel;
import fr.arinonia.dashboardfx.utils.Constants;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Arinonia
 * Created at 06/12/2021 - 18:05
 **/
public class PanelManager {

    private final DashBoard dashBoard;

    private Stage stage;
    private GridPane layout;

    public PanelManager(final DashBoard dashBoard) {
        this.dashBoard = dashBoard;
    }

    public void createFrame(final Stage stage) {
        this.stage = stage;
        this.stage.setTitle(Constants.APP_NAME);
        this.stage.setMinWidth(1280.0D);
        this.stage.setWidth(1280.0D);
        this.stage.setMinHeight(720.0D);
        this.stage.setHeight(720.0D);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toExternalForm()));
        this.stage.centerOnScreen();
        this.stage.setOnCloseRequest(e -> System.exit(0));
        this.stage.setScene(new Scene(this.layout = new GridPane()));
        this.stage.show();
    }

    public void showPanel(final GridPane layout, final IPanel iPanel, final boolean clear) {
        if (clear) {
            layout.getChildren().clear();
            layout.getChildren().remove(iPanel.getLayout());
        }
        layout.getChildren().add(iPanel.getLayout());
        iPanel.init(this);
    }

    public void showPanel(final GridPane layout, final IPanel iPanel) {
        this.showPanel(layout, iPanel, true);
    }

    public GridPane getLayout() {
        return this.layout;
    }

    public DashBoard getDashBoard() {
        return dashBoard;
    }

    public Stage getStage() {
        return this.stage;
    }
}
