package fr.arinonia.dashboardfx;

import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.panels.RootPanel;
import javafx.stage.Stage;

/**
 * @author Arinonia
 * Created at 06/12/2021 - 18:03
 **/
public class DashBoard {

    private final PanelManager panelManager = new PanelManager(this);


    public void init(final Stage stage) {
        this.panelManager.createFrame(stage);
        this.panelManager.showPanel(this.panelManager.getLayout(), new RootPanel());
    }
}
