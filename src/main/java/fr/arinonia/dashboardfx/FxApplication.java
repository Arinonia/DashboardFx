package fr.arinonia.dashboardfx;

import javafx.application.Application;
import javafx.stage.Stage;

public class FxApplication extends Application {

    @Override
    public void start(final Stage stage) {
        new DashBoard().init(stage);
    }
}
