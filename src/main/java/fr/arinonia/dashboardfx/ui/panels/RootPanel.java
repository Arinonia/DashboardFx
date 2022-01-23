package fr.arinonia.dashboardfx.ui.panels;

import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.includes.TopBar;
import fr.arinonia.dashboardfx.ui.panel.Panel;
import fr.arinonia.dashboardfx.ui.panels.home.ProjectPanel;
import fr.arinonia.dashboardfx.ui.panels.home.LeftHomePanel;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * @author Arinonia
 * Created at 07/12/2021 - 23:59
 **/
public class RootPanel extends Panel {

    private final GridPane centerPanel = new GridPane();


    @Override
    public void init(final PanelManager panelManager) {
        super.init(panelManager);
        GridPane.setHgrow(centerPanel, Priority.ALWAYS);
        GridPane.setVgrow(centerPanel, Priority.ALWAYS);

        final RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setValignment(VPos.TOP);
        rowConstraints.setMinHeight(26.0D);
        rowConstraints.setMaxHeight(26.0D);

        this.layout.getRowConstraints().addAll(rowConstraints, new RowConstraints());
        final TopBar topPanel = new TopBar(panelManager);
        final GridPane pane = new GridPane();
        GridPane.setHgrow(pane, Priority.ALWAYS);
        GridPane.setVgrow(pane, Priority.ALWAYS);
        this.layout.setStyle("-fx-background-image: url('"+ Main.class.getResource("/images/background.png") + "'); -fx-backgound-repeat: skretch; -fx-backgound-position: center center; -fx-background-size: cover;");

        this.layout.add(topPanel.getLayout(), 0, 0);
        this.layout.add(pane, 0, 1);

        final ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(280);
        col1.setMaxWidth(280);
        col1.setMinWidth(280);

        final ColumnConstraints col2 = new ColumnConstraints();
        pane.getColumnConstraints().addAll(col1, col2);

        final LeftHomePanel leftHomePanel = new LeftHomePanel(this);
        leftHomePanel.init(panelManager);

        pane.add(leftHomePanel.getLayout(), 0, 0);
        pane.add(this.centerPanel, 1, 0);

        this.panelManager.showPanel(this.centerPanel, new ProjectPanel());
    }

    public GridPane getCenterPanel() {
        return this.centerPanel;
    }
}
