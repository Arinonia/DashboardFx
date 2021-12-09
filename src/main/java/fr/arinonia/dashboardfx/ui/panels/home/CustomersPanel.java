package fr.arinonia.dashboardfx.ui.panels.home;

import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.panel.Panel;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 19:30
 **/
public class CustomersPanel extends Panel {

    @Override
    public void init(final PanelManager panelManager) {
        super.init(panelManager);
        this.layout.setStyle("-fx-background-color: rgba(33, 33, 33, 0.8)");

    }
}
