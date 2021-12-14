package fr.arinonia.dashboardfx.ui.panels.home;

import fr.arinonia.dashboardfx.customers.CustomersData;
import fr.arinonia.dashboardfx.customers.CustomersUtil;
import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.controls.Card;
import fr.arinonia.dashboardfx.ui.controls.CircleButton;
import fr.arinonia.dashboardfx.ui.controls.CustomersCard;
import fr.arinonia.dashboardfx.ui.controls.PanelList;
import fr.arinonia.dashboardfx.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 19:30
 **/
public class CustomersPanel extends Panel {

    @Override
    public void init(final PanelManager panelManager) {
        super.init(panelManager);
        final GridPane background = new GridPane();
        GridPane.setHgrow(background, Priority.ALWAYS);
        GridPane.setVgrow(background, Priority.ALWAYS);
        background.setStyle("-fx-background-color: rgba(33, 33, 33, 0.8)");
        this.layout.getChildren().add(background);

        final RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setValignment(VPos.BOTTOM);
        rowConstraints.setMinHeight(100.0D);
        rowConstraints.setMaxHeight(100.0D);
        background.getRowConstraints().addAll(new RowConstraints(), rowConstraints);

        final GridPane topPane = new GridPane();
        GridPane.setHgrow(topPane, Priority.ALWAYS);
        GridPane.setVgrow(topPane, Priority.ALWAYS);

        final GridPane bottomPane = new GridPane();
        GridPane.setHgrow(bottomPane, Priority.ALWAYS);
        GridPane.setVgrow(bottomPane, Priority.ALWAYS);
        background.add(topPane, 0, 0);
        background.add(bottomPane, 0, 1);

        final PanelList panelList = new PanelList();
        GridPane.setHgrow(panelList, Priority.ALWAYS);
        GridPane.setVgrow(panelList, Priority.ALWAYS);
        GridPane.setValignment(panelList, VPos.TOP);
        GridPane.setHalignment(panelList, HPos.CENTER);
        panelList.getLayout().setSpacing(20.0D);
        panelList.getLayout().setAlignment(Pos.TOP_CENTER);
        topPane.getChildren().add(panelList);

        for (CustomersData customersData : this.panelManager.getDashBoard().getCustomersUtils().loadCustomers()) {
            CustomersCard card = new CustomersCard(customersData.getName(), customersData.getEmail(), customersData.getImage(), customersData.getDate());
            panelList.add(card);
        }


        this.setupBottomPanel(bottomPane);
    }

    private void setupBottomPanel(final GridPane bottomPane) {
        CircleButton circleButton = new CircleButton();
        GridPane.setHalignment(circleButton, HPos.RIGHT);
        GridPane.setValignment(circleButton, VPos.CENTER);
        circleButton.setOnMouseClicked(e -> this.panelManager.showPanel(this.layout, new AddCustomersPanel()));
        bottomPane.getChildren().add(circleButton);
        bottomPane.setPadding(new Insets(0, 10, 0, 0));
    }
}
