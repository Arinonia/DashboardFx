package fr.arinonia.dashboardfx.ui.panel;

import fr.arinonia.dashboardfx.ui.PanelManager;
import javafx.scene.layout.GridPane;

/**
 * @author Arinonia
 * Created at 06/12/2021 - 18:04
 **/
public interface IPanel {
    void init(PanelManager panelManager);
    GridPane getLayout();
    PanelManager getPanelManager();
}
