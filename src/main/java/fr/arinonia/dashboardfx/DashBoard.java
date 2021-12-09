package fr.arinonia.dashboardfx;

import fr.arinonia.dashboardfx.customers.Customers;
import fr.arinonia.dashboardfx.file.FileManager;
import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.panels.RootPanel;
import javafx.stage.Stage;

/**
 * @author Arinonia
 * Created at 06/12/2021 - 18:03
 **/
public class DashBoard {

    private final PanelManager panelManager = new PanelManager(this);
    private final FileManager fileManager = new FileManager();
    private final Customers customersUtils = new Customers(fileManager);

    public void init(final Stage stage) {
        this.panelManager.createFrame(stage);
        this.panelManager.showPanel(this.panelManager.getLayout(), new RootPanel());
    }


    public FileManager getFileManager() {
        return this.fileManager;
    }

    public Customers getCustomersUtils() {
        return this.customersUtils;
    }
}
