package fr.arinonia.dashboardfx.ui.panel;

import fr.arinonia.dashboardfx.ui.PanelManager;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * @author Arinonia
 * Created at 07/12/2021 - 23:42
 **/
public class Panel implements IPanel {

    protected final GridPane layout = new GridPane();
    protected PanelManager panelManager;

    @Override
    public void init(final PanelManager panelManager) {
        this.panelManager = panelManager;
        GridPane.setHgrow(this.layout, Priority.ALWAYS);
        GridPane.setVgrow(this.layout, Priority.ALWAYS);
    }

    @Override
    public GridPane getLayout() {
        return this.layout;
    }

    @Override
    public PanelManager getPanelManager() {
        return this.panelManager;
    }
}
