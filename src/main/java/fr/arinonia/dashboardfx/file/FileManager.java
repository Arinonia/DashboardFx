package fr.arinonia.dashboardfx.file;

import fr.arinonia.dashboardfx.utils.Constants;

import java.io.File;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 00:02
 **/
public class FileManager {


    public File getRootFolder() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win"))
            return new File(System.getProperty("user.home") + "\\AppData\\Roaming\\" + "Arinonia\\" + Constants.APP_NAME);
        else if (os.contains("mac"))
            return new File(System.getProperty("user.home") + "/Library/Application Support/" + "Arinonia/" + Constants.APP_NAME);
        else
            return new File(System.getProperty("user.home") + "/" + "Arinonia/" + Constants.APP_NAME);
    }

    public File getCustomersFolder() {
        return new File(this.getRootFolder(), "customers");
    }

    public File getProjectsFolder() {
        return new File(this.getRootFolder(), "projects");
    }
    public File getMoneyEarnFolder() {
        return new File(this.getRootFolder(), "money");
    }

    public File getSettingsFolder() {
        return new File(this.getRootFolder(), "settings");
    }

}
