package fr.arinonia.dashboardfx.ui.panels.home;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.customers.CustomersData;
import fr.arinonia.dashboardfx.customers.SimpleCustomersProperty;
import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.controls.MaterialComboBox;
import fr.arinonia.dashboardfx.ui.panel.Panel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * @author Arinonia
 * Created at 10/12/2021 - 02:39
 **/
public class AddProjectPanel extends Panel {

    @Override
    public void init(final PanelManager panelManager) {
        super.init(panelManager);

        final MaterialComboBox materialComboBox = new MaterialComboBox();
        materialComboBox.setMaxSize(300.0D, 50.0D);
        this.layout.getChildren().add(materialComboBox);


        JFXTreeTableColumn<SimpleCustomersProperty, String> nameColumn = new JFXTreeTableColumn<>("Name");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<SimpleCustomersProperty, String> param) -> {
            if (nameColumn.validateValue(param)) {
                return param.getValue().getValue().nameProperty();
            } else {
                return nameColumn.getComputedValue(param);
            }
        });

        JFXTreeTableColumn<SimpleCustomersProperty, String> emailColumn = new JFXTreeTableColumn<>("Email");
        emailColumn.setPrefWidth(150);
        emailColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<SimpleCustomersProperty, String> param) -> {
            if (emailColumn.validateValue(param)) {
                return param.getValue().getValue().emailProperty();
            } else {
                return emailColumn.getComputedValue(param);
            }
        });

        JFXTreeTableColumn<SimpleCustomersProperty, ImageView> pp = new JFXTreeTableColumn<>("");
        pp.setPrefWidth(100);
        pp.setCellValueFactory((TreeTableColumn.CellDataFeatures<SimpleCustomersProperty, ImageView> param) -> {
            if (pp.validateValue(param)) {
                return param.getValue().getValue().imageProperty();
            } else {
                return pp.getComputedValue(param);
            }
        });

        JFXTreeTableColumn<SimpleCustomersProperty, String> dateColumn = new JFXTreeTableColumn<>("Date");
        dateColumn.setPrefWidth(150);
        dateColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<SimpleCustomersProperty, String> param) -> {
            if (dateColumn.validateValue(param)) {
                return param.getValue().getValue().dateProperty();
            } else {
                return dateColumn.getComputedValue(param);
            }
        });

        ObservableList<SimpleCustomersProperty> users = FXCollections.observableArrayList();

        for (CustomersData customersData : this.panelManager.getDashBoard().getCustomersUtils().loadCustomers()) {
            final Circle circle = new Circle(30, 30, 25);
            Image img = new Image("file:///" + customersData.getImage().replaceAll("\\\\", "/"));
            final ImageView imageView = new ImageView(img);
            imageView.setFitWidth(60);
            imageView.setFitHeight(60);
            imageView.setClip(circle);
            circle.setFill(new ImagePattern(img));
            users.add(new SimpleCustomersProperty(customersData.getName(), customersData.getEmail(), imageView, customersData.getDate()));
        }

        /*Image img = new Image(Main.class.getResource("/images/icon.png").toExternalForm());
        final ImageView imageView = new ImageView(img);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        /*users.add(new SimpleCustomersProperty("john", "sfefse.fes@dqz.com", imageView));
        users.add(new SimpleCustomersProperty("tamere", "sfefse.fes@dqz.com", imageView));
        users.add(new SimpleCustomersProperty("lapute", "sfefse.fes@dqz.com", imageView));
        users.add(new SimpleCustomersProperty("quisuce", "sfefse.fes@dqz.com", imageView));
        users.add(new SimpleCustomersProperty("desbites", "sfefse.fes@dqz.com", imageView));
        users.add(new SimpleCustomersProperty("dedromadaire", "sfefse.fes@dqz.com", imageView));
        users.add(new SimpleCustomersProperty("etdours", "sfefse.fes@dqz.com", imageView));
        users.add(new SimpleCustomersProperty("etdetriceratops", "sfefse.fes@dqz.com", imageView));*/

        final TreeItem<SimpleCustomersProperty> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);

        final JFXTreeTableView<SimpleCustomersProperty> treeView = new JFXTreeTableView<>(root);
        GridPane.setHgrow(treeView, Priority.ALWAYS);
        GridPane.setVgrow(treeView, Priority.ALWAYS);
        GridPane.setHalignment(treeView, HPos.RIGHT);
        GridPane.setValignment(treeView, VPos.TOP);
        treeView.setTranslateY(50.0D);

        treeView.setMaxSize(600, 460);
        treeView.setShowRoot(false);
        treeView.setEditable(false);

        treeView.getColumns().setAll(pp, nameColumn, emailColumn, dateColumn);

        JFXTextField filterField = new JFXTextField();
        GridPane.setHgrow(filterField, Priority.ALWAYS);
        GridPane.setVgrow(filterField, Priority.ALWAYS);
        GridPane.setHalignment(filterField, HPos.RIGHT);
        GridPane.setValignment(filterField, VPos.TOP);
        filterField.setMaxSize(600, 40);
        filterField.setMinSize(600, 40);

        filterField.setPromptText("Search");
        this.layout.getChildren().add(filterField);

        filterField.textProperty().addListener((o, oldVal, newVal) -> {
            treeView.setPredicate(userProp -> {
                final SimpleCustomersProperty user = userProp.getValue();
                return user.nameProperty().get().contains(newVal)
                        || user.emailProperty().get().contains(newVal);
            });
        });

        this.layout.getChildren().add(treeView);

        this.layout.getStylesheets().add(Main.class.getResource("/css/test.css").toExternalForm());
    }
}