package fr.arinonia.dashboardfx.ui.panels.home;

import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.controls.Card;
import fr.arinonia.dashboardfx.ui.controls.CircleButton;
import fr.arinonia.dashboardfx.ui.controls.PanelList;
import fr.arinonia.dashboardfx.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 00:36
 **/
public class ProjectPanel extends Panel {

    @Override
    public void init(final PanelManager panelManager) {
        super.init(panelManager);
        this.layout.setStyle("-fx-background-color: rgba(33, 33, 33, 0.8)");

        final GridPane test = new GridPane();
        GridPane.setHgrow(test, Priority.ALWAYS);
        GridPane.setVgrow(test, Priority.ALWAYS);
        this.layout.getChildren().add(test);

        final RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setValignment(VPos.BOTTOM);
        rowConstraints.setMinHeight(100.0D);
        rowConstraints.setMaxHeight(100.0D);
        test.getRowConstraints().addAll(new RowConstraints(), rowConstraints);

        final GridPane topPane = new GridPane();
        GridPane.setHgrow(topPane, Priority.ALWAYS);
        GridPane.setVgrow(topPane, Priority.ALWAYS);

        final GridPane bottomPane = new GridPane();
        GridPane.setHgrow(bottomPane, Priority.ALWAYS);
        GridPane.setVgrow(bottomPane, Priority.ALWAYS);
        test.add(topPane, 0, 0);
        test.add(bottomPane, 0, 1);

        final PanelList panelList = new PanelList();
        GridPane.setHgrow(panelList, Priority.ALWAYS);
        GridPane.setVgrow(panelList, Priority.ALWAYS);
        GridPane.setValignment(panelList, VPos.TOP);
        GridPane.setHalignment(panelList, HPos.CENTER);
        panelList.getLayout().setSpacing(20.0D);
        panelList.getLayout().setAlignment(Pos.TOP_CENTER);
        topPane.getChildren().add(panelList);

        Card card = new Card();
        panelList.add(card);

        Card card2 = new Card();
        panelList.add(card2);

        Card card3 = new Card();
        panelList.add(card3);

        Card card4 = new Card();
        panelList.add(card4);

        Card card5 = new Card();
        panelList.add(card5);

        Card card6 = new Card();
        panelList.add(card6);

        Card card7 = new Card();
        panelList.add(card7);

        Card card8 = new Card();
        panelList.add(card8);
        this.setupBottomPanel(bottomPane);
    }

    private void setupBottomPanel(final GridPane bottomPane) {
        CircleButton circleButton = new CircleButton();
        GridPane.setHalignment(circleButton, HPos.RIGHT);
        GridPane.setValignment(circleButton, VPos.CENTER);
        circleButton.setOnMouseClicked(e -> this.panelManager.showPanel(this.layout, new AddProjectPanel()));
        bottomPane.getChildren().add(circleButton);
        bottomPane.setPadding(new Insets(0, 10, 0, 0));
    }
}
