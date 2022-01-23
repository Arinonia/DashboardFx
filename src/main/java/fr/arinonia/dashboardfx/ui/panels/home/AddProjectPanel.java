package fr.arinonia.dashboardfx.ui.panels.home;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.customers.CustomersData;
import fr.arinonia.dashboardfx.customers.SimpleCustomersProperty;
import fr.arinonia.dashboardfx.projects.ProjectData;
import fr.arinonia.dashboardfx.projects.ProjectEnum;
import fr.arinonia.dashboardfx.projects.ProjectStateEnum;
import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.controls.MaterialComboBox;
import fr.arinonia.dashboardfx.ui.panel.Panel;
import fr.arinonia.dashboardfx.utils.Constants;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Arinonia
 * Created at 10/12/2021 - 02:39
 **/
public class AddProjectPanel extends Panel {

    @Override
    public void init(final PanelManager panelManager) {
        super.init(panelManager);


        final Label project_type_label = new Label("Chose a type");
        GridPane.setHgrow(project_type_label, Priority.ALWAYS);
        GridPane.setVgrow(project_type_label, Priority.ALWAYS);
        GridPane.setHalignment(project_type_label, HPos.LEFT);
        GridPane.setValignment(project_type_label, VPos.TOP);
        project_type_label.setStyle("-fx-font-size: 24px; -fx-font-family: Inconsolata; -fx-text-fill: #FFF;");
        project_type_label.setTranslateX(10.0D);
        project_type_label.setTranslateY(10.0D);
        this.layout.getChildren().add(project_type_label);


        final MaterialComboBox project_type_combobox = new MaterialComboBox();
        GridPane.setHgrow(project_type_combobox, Priority.ALWAYS);
        GridPane.setVgrow(project_type_combobox, Priority.ALWAYS);
        GridPane.setHalignment(project_type_combobox, HPos.LEFT);
        GridPane.setValignment(project_type_combobox, VPos.TOP);
        project_type_combobox.setTranslateX(10.0D);
        project_type_combobox.setTranslateY(60.0D);
        project_type_combobox.setMaxSize(300.0D, 50.0D);
        this.layout.getChildren().add(project_type_combobox);

        for (final ProjectEnum projects : ProjectEnum.values()) {
            project_type_combobox.getItems().add(projects.name());
        }
        project_type_combobox.getSelectionModel().select(0);


        final Label project_state_label = new Label("Chose a State");
        GridPane.setHgrow(project_state_label, Priority.ALWAYS);
        GridPane.setVgrow(project_state_label, Priority.ALWAYS);
        GridPane.setHalignment(project_state_label, HPos.LEFT);
        GridPane.setValignment(project_state_label, VPos.TOP);
        project_state_label.setStyle("-fx-font-size: 24px; -fx-font-family: Inconsolata; -fx-text-fill: #FFF;");
        project_state_label.setTranslateX(10.0D);
        project_state_label.setTranslateY(130.0D);
        this.layout.getChildren().add(project_state_label);


        final MaterialComboBox project_state_combobox = new MaterialComboBox();
        GridPane.setHgrow(project_state_combobox, Priority.ALWAYS);
        GridPane.setVgrow(project_state_combobox, Priority.ALWAYS);
        GridPane.setHalignment(project_state_combobox, HPos.LEFT);
        GridPane.setValignment(project_state_combobox, VPos.TOP);
        project_state_combobox.setTranslateX(10.0D);
        project_state_combobox.setTranslateY(190.0D);
        project_state_combobox.setMaxSize(300.0D, 50.0D);
        this.layout.getChildren().add(project_state_combobox);

        for (final ProjectStateEnum projects : ProjectStateEnum.values()) {
            project_state_combobox.getItems().add(projects.name());
        }
        project_state_combobox.getSelectionModel().select(0);


        final GridPane datePane = new GridPane();
        GridPane.setHgrow(datePane, Priority.ALWAYS);
        GridPane.setVgrow(datePane, Priority.ALWAYS);
        GridPane.setHalignment(datePane, HPos.LEFT);
        GridPane.setValignment(datePane, VPos.TOP);
        datePane.setStyle("-fx-background-color: rgba(44, 44, 44, 0.6); -fx-background-radius: 15px; -fx-border-width: 1px; -fx-border-radius: 15px;  -fx-border-color: #" + Constants.PURPLE + ";");
        datePane.setMaxSize(300, 100);
        datePane.setTranslateY(270.0D);
        datePane.setTranslateX(10.0D);
        datePane.setPadding(new Insets(10.0D));
        this.layout.getChildren().add(datePane);


        final Label dateLabel = new Label("DeadLine");
        GridPane.setHgrow(dateLabel, Priority.ALWAYS);
        GridPane.setVgrow(dateLabel, Priority.ALWAYS);
        GridPane.setValignment(dateLabel, VPos.TOP);
        GridPane.setHalignment(dateLabel, HPos.CENTER);
        dateLabel.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 36px; -fx-text-fill: #FFF");
        datePane.getChildren().add(dateLabel);


        final JFXDatePicker datePicker = new JFXDatePicker(LocalDate.now());
        GridPane.setHgrow(datePicker, Priority.ALWAYS);
        GridPane.setVgrow(datePicker, Priority.ALWAYS);
        GridPane.setValignment(datePicker, VPos.BOTTOM);
        GridPane.setHalignment(datePicker, HPos.CENTER);

        datePicker.getStylesheets().add(Main.class.getResource("/css/datepicker.css").toExternalForm());
        datePicker.setMinSize(200.0D, 30.0D);
        datePane.getChildren().add(datePicker);

        final GridPane pricePane = new GridPane();
        GridPane.setHgrow(pricePane, Priority.ALWAYS);
        GridPane.setVgrow(pricePane, Priority.ALWAYS);
        GridPane.setHalignment(pricePane, HPos.LEFT);
        GridPane.setValignment(pricePane, VPos.TOP);
        pricePane.setStyle("-fx-background-color: rgba(44, 44, 44, 0.6); -fx-background-radius: 15px; -fx-border-width: 1px; -fx-border-radius: 15px; -fx-border-color: #" + Constants.PURPLE + ";");
        pricePane.setMaxSize(300, 100);
        pricePane.setTranslateY(390.0D);
        pricePane.setTranslateX(10.0D);
        this.layout.getChildren().add(pricePane);

        final Label priceLabel = new Label("Price");
        GridPane.setHgrow(priceLabel, Priority.ALWAYS);
        GridPane.setVgrow(priceLabel, Priority.ALWAYS);
        GridPane.setValignment(priceLabel, VPos.TOP);
        GridPane.setHalignment(priceLabel, HPos.CENTER);
        priceLabel.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 36px; -fx-text-fill: #FFF");
        pricePane.getChildren().add(priceLabel);

        final JFXTextField priceField = new JFXTextField();
        GridPane.setHgrow(priceField, Priority.ALWAYS);
        GridPane.setVgrow(priceField, Priority.ALWAYS);
        GridPane.setValignment(priceField, VPos.BOTTOM);
        GridPane.setHalignment(priceField, HPos.CENTER);
        priceField.setStyle("-jfx-focus-color: rgb(0, 150, 136); -fx-font-size: 18px; -fx-text-fill: white; -fx-font-family: Inconsolata; -fx-prompt-text-fill: rgb(180, 180, 180);");
        priceField.setTranslateY(-10.0D);
        priceField.setMaxSize(180.0D, 30.0D);
        priceField.setPromptText("Price");
        pricePane.getChildren().add(priceField);

        final JFXTreeTableColumn<SimpleCustomersProperty, ImageView> pp = new JFXTreeTableColumn<>("");
        pp.setPrefWidth(70);
        pp.setSortable(false);
        pp.setCellValueFactory((TreeTableColumn.CellDataFeatures<SimpleCustomersProperty, ImageView> param) -> {
            if (pp.validateValue(param)) {
                return param.getValue().getValue().imageProperty();
            } else {
                return pp.getComputedValue(param);
            }
        });

        final JFXTreeTableColumn<SimpleCustomersProperty, String> nameColumn = new JFXTreeTableColumn<>("Name");
        nameColumn.setPrefWidth(150);
        nameColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<SimpleCustomersProperty, String> param) -> {
            if (nameColumn.validateValue(param)) {
                return param.getValue().getValue().nameProperty();
            } else {
                return nameColumn.getComputedValue(param);
            }
        });

        final JFXTreeTableColumn<SimpleCustomersProperty, String> emailColumn = new JFXTreeTableColumn<>("Email");
        emailColumn.setPrefWidth(228);
        emailColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<SimpleCustomersProperty, String> param) -> {
            if (emailColumn.validateValue(param)) {
                return param.getValue().getValue().emailProperty();
            } else {
                return emailColumn.getComputedValue(param);
            }
        });

        final JFXTreeTableColumn<SimpleCustomersProperty, String> dateColumn = new JFXTreeTableColumn<>("Date");
        dateColumn.setPrefWidth(150);
        dateColumn.setCellValueFactory((TreeTableColumn.CellDataFeatures<SimpleCustomersProperty, String> param) -> {
            if (dateColumn.validateValue(param)) {
                return param.getValue().getValue().dateProperty();
            } else {
                return dateColumn.getComputedValue(param);
            }
        });

        final ObservableList<SimpleCustomersProperty> users = FXCollections.observableArrayList();

        for (final CustomersData customersData : this.panelManager.getDashBoard().getCustomersUtils().loadCustomers(true)) {
            final Circle circle = new Circle(30, 30, 25);
            ImageView imageView;
            if (!customersData.getImage().equalsIgnoreCase("null")) {
                Image img = new Image("file:///" + customersData.getImage().replaceAll("\\\\", "/"));
                imageView = new ImageView(img);
            } else {
                imageView = new ImageView(new Image(Main.class.getResource("/images/icon.png").toExternalForm()));
            }
            imageView.setFitWidth(60);
            imageView.setFitHeight(60);
            imageView.setClip(circle);
            users.add(new SimpleCustomersProperty(customersData.getName(), customersData.getEmail(), imageView, customersData.getDate()));


        }

        final TreeItem<SimpleCustomersProperty> root = new RecursiveTreeItem<>(users, RecursiveTreeObject::getChildren);

        final JFXTreeTableView<SimpleCustomersProperty> treeView = new JFXTreeTableView<>(root);
        GridPane.setHgrow(treeView, Priority.ALWAYS);
        GridPane.setVgrow(treeView, Priority.ALWAYS);
        GridPane.setHalignment(treeView, HPos.RIGHT);
        GridPane.setValignment(treeView, VPos.TOP);
        treeView.setTranslateY(41.0D);
        treeView.getStylesheets().add(Main.class.getResource("/css/treeview.css").toExternalForm());
        treeView.getStylesheets().add(Main.class.getResource("/css/bar.css").toExternalForm());

        treeView.setMaxSize(620, 460);
        treeView.setShowRoot(false);
        treeView.setEditable(false);

        treeView.getColumns().setAll(pp, nameColumn, emailColumn, dateColumn);

        JFXTextField filterField = new JFXTextField();
        GridPane.setHgrow(filterField, Priority.ALWAYS);
        GridPane.setVgrow(filterField, Priority.ALWAYS);
        GridPane.setHalignment(filterField, HPos.RIGHT);
        GridPane.setValignment(filterField, VPos.TOP);
        filterField.setMaxSize(620, 40);
        filterField.setMinSize(620, 40);
        filterField.setStyle("-fx-font-family: Inconsolata; -fx-text-fill: #FFF; -fx-font-size: 18px; -fx-prompt-text-fill: #4e4e4e; -fx-background-color: #1E1E1E; -fx-background-radius: 0; -jfx-focus-color: #" + Constants.PURPLE + ";");
        filterField.setPromptText("Select your customers");
        this.layout.getChildren().add(filterField);

        filterField.textProperty().addListener((o, oldVal, newVal) -> {
            treeView.setPredicate(userProp -> {
                final SimpleCustomersProperty user = userProp.getValue();
                return user.nameProperty().get().toLowerCase(Locale.ROOT).contains(newVal.toLowerCase(Locale.ROOT))
                        || user.emailProperty().get().toLowerCase(Locale.ROOT).contains(newVal.toLowerCase(Locale.ROOT));
            });
        });

        this.layout.getChildren().add(treeView);

        final JFXButton test = new JFXButton("Add project");
        GridPane.setHgrow(test, Priority.ALWAYS);
        GridPane.setVgrow(test, Priority.ALWAYS);
        GridPane.setValignment(test, VPos.BOTTOM);
        GridPane.setHalignment(test, HPos.CENTER);
        test.setMaxSize(300.0D, 40.0D);
        test.setTranslateY(-100.0D);
        test.setStyle("-fx-border-color: #" + Constants.PURPLE + ";  -fx-border-width: 1px; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-family: Inconsolata;");
        test.setCursor(Cursor.HAND);
        test.setOnMouseClicked(event -> {
                this.panelManager.getDashBoard().getProjectUtils()
                        .createCustomers(new ProjectData(ProjectStateEnum.valueOf(project_state_combobox.getSelectionModel().getSelectedItem()),
                                ProjectEnum.valueOf(project_type_combobox.getSelectionModel().getSelectedItem()),
                                new CustomersData(treeView.getSelectionModel().getSelectedItem().getValue().getName(),
                                        treeView.getSelectionModel().getSelectedItem().getValue().getEmail(),
                                        treeView.getSelectionModel().getSelectedItem().getValue().getImage().getImage().impl_getUrl(),
                                        treeView.getSelectionModel().getSelectedItem().getValue().getDate()), datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), priceField.getText(), ""));
            System.err.println("'getImage().impl_getUrl()' is Deprecated, i need to found something else for get the path");
        });
        layout.getChildren().add(test);
    }
}
