package fr.arinonia.dashboardfx.ui.panels.home;

import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.controls.BarButton;
import fr.arinonia.dashboardfx.ui.panel.Panel;
import fr.arinonia.dashboardfx.ui.panels.RootPanel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 00:31
 **/
public class LeftHomePanel extends Panel {

    private final List<BarButton> buttons = new ArrayList<>();

    private final RootPanel rootPanel;

    public LeftHomePanel(final RootPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    @Override
    public void init(final PanelManager panelManager) {
        super.init(panelManager);
        this.layout.setStyle("-fx-background-color: rgba(21, 21, 21, 0.9654);");


        final Image icon = new Image(Main.class.getResource("/images/icon.png").toExternalForm());
        final ImageView iconView = new ImageView(icon);
        GridPane.setHgrow(iconView, Priority.ALWAYS);
        GridPane.setVgrow(iconView, Priority.ALWAYS);
        GridPane.setValignment(iconView, VPos.TOP);
        GridPane.setHalignment(iconView, HPos.CENTER);
        iconView.setTranslateY(30.0D);
        iconView.setFitWidth(100.0D);
        iconView.setFitHeight(100.0D);
        this.layout.getChildren().add(iconView);

        final GridPane iconSeparator = new GridPane();
        GridPane.setHgrow(iconSeparator, Priority.ALWAYS);
        GridPane.setVgrow(iconSeparator, Priority.ALWAYS);
        GridPane.setValignment(iconSeparator, VPos.TOP);
        GridPane.setHalignment(iconSeparator, HPos.CENTER);
        iconSeparator.setTranslateY(150.0D);
        iconSeparator.setMaxSize(200, 1);
        iconSeparator.setBackground(new Background(new BackgroundFill(Color.rgb(88, 88, 88), null, null)));
        this.layout.getChildren().add(iconSeparator);

        final VBox vBox = new VBox();
        GridPane.setHgrow(vBox, Priority.ALWAYS);
        GridPane.setVgrow(vBox, Priority.ALWAYS);
        GridPane.setValignment(vBox, VPos.TOP);
        GridPane.setHalignment(vBox, HPos.CENTER);

        vBox.setTranslateY(200.0D);
        vBox.setSpacing(20.0D);
        vBox.setMaxHeight(400.0D);
        vBox.setMaxWidth(200.0D);
        this.layout.getChildren().add(vBox);


        final BarButton projects = new BarButton("Projects", true);
        projects.setOnClick(new ProjectPanel(), this.buttons, this.rootPanel);
        this.buttons.add(projects);

        final BarButton customers = new BarButton("Customers");
        customers.setOnClick(new ProjectPanel(), this.buttons, this.rootPanel);
        this.buttons.add(customers);

        final BarButton earn = new BarButton("Earn");
        earn.setOnClick(new ProjectPanel(), this.buttons, this.rootPanel);
        this.buttons.add(earn);

        vBox.getChildren().add(projects);
        vBox.getChildren().add(customers);
        vBox.getChildren().add(earn);


    }
}
