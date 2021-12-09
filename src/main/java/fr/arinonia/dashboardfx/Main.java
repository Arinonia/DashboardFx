package fr.arinonia.dashboardfx;

import com.sun.javafx.application.LauncherImpl;
import fr.arinonia.dashboardfx.preloader.FxPreloader;

/**
 * @author Arinonia
 * Created at 06/12/2021 - 18:01
 **/
public class Main {

    public static void main(String[] args) {
        LauncherImpl.launchApplication(FxApplication.class, FxPreloader.class, args);
    }

}
