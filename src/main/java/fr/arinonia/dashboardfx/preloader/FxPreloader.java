package fr.arinonia.dashboardfx.preloader;

import fr.arinonia.dashboardfx.DashBoard;
import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.customers.Customers;
import fr.arinonia.dashboardfx.customers.CustomersData;
import fr.arinonia.dashboardfx.utils.Constants;
import javafx.application.Preloader;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 02:45
 **/
public class FxPreloader extends Preloader {

    private Stage stage;
    private GridPane layout;

    @Override
    public void start(final Stage stage)   {
        this.stage = stage;
        this.stage.setTitle(Constants.APP_NAME);
        this.stage.setMinWidth(600.0D);
        this.stage.setWidth(600.0D);
        this.stage.setMinHeight(320.0D);
        this.stage.setHeight(320.0D);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.getIcons().add(new Image(Main.class.getResource("/images/icon.png").toExternalForm()));
        this.stage.centerOnScreen();
        this.stage.setScene(new Scene(this.layout = new GridPane()));
        this.stage.show();

        this.layout.setStyle("-fx-background-image: url('"+ Main.class.getResource("/images/background.png") + "'); -fx-backgound-repeat: skretch; -fx-backgound-position: center center; -fx-background-size: cover;");

        final Label label = new Label("Wait a minute !");
        GridPane.setHgrow(label, Priority.ALWAYS);
        GridPane.setVgrow(label, Priority.ALWAYS);
        GridPane.setValignment(label, VPos.CENTER);
        GridPane.setHalignment(label, HPos.CENTER);
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");
        this.layout.getChildren().add(label);
        DashBoard dashBoard = new DashBoard();

        if (!dashBoard.getFileManager().getRootFolder().exists()) {
            if (!dashBoard.getFileManager().getRootFolder().mkdirs()) {
                System.err.println("Cannot create folder");
            }
        }
        if (!dashBoard.getFileManager().getCustomersFolder().exists()) {
            if (!dashBoard.getFileManager().getCustomersFolder().mkdirs()) {
                System.err.println("Cannot create folder");
            }
        }
        if (!dashBoard.getFileManager().getProjectsFolder().exists()) {
            if (!dashBoard.getFileManager().getProjectsFolder().mkdirs()) {
                System.err.println("Cannot create folder");
            }
        }
        if (!dashBoard.getFileManager().getMoneyEarnFolder().exists()) {
            if (!dashBoard.getFileManager().getMoneyEarnFolder().mkdirs()) {
                System.err.println("Cannot create folder");
            }
        }
        if (!dashBoard.getFileManager().getSettingsFolder().exists()) {
            if (!dashBoard.getFileManager().getSettingsFolder().mkdirs()) {
                System.err.println("Cannot create folder");
            }
        }

        if (!new File(dashBoard.getFileManager().getCustomersFolder(), "me.customers").exists()) {
            new Customers(dashBoard.getFileManager()).createCustomers(new CustomersData("Me", "unknown@name.domaine", "null"));
        }
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
        if (stateChangeNotification.getType() == StateChangeNotification.Type.BEFORE_START) {
            this.stage.hide();
        }
    }
}
