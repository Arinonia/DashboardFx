package fr.arinonia.dashboardfx.ui.panel;

import fr.arinonia.dashboardfx.ui.PanelManager;
import javafx.animation.FadeTransition;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Duration;

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
        this.layout.getChildren().clear();
    }

    public void onShow() {
        final FadeTransition transition = new FadeTransition(Duration.seconds(1), this.layout);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.setAutoReverse(true);
        transition.play();
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
