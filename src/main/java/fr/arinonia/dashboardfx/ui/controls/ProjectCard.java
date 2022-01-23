package fr.arinonia.dashboardfx.ui.controls;

import com.jfoenix.controls.JFXDatePicker;
import fr.arinonia.dashboardfx.DashBoard;
import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.projects.ProjectData;
import fr.arinonia.dashboardfx.projects.ProjectStateEnum;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.time.LocalDate;

/**
 * @author Arinonia
 * Created at 23/01/2022 - 04:26
 **/
public class ProjectCard extends Card {



    public ProjectCard(final ProjectData projectData, final DashBoard dashBoard) {
        super();
        final Circle circle = new Circle(0, 0, 25);
        final Image imageView = new Image(projectData.getCustomersData().getImage());
        circle.setFill(new ImagePattern(imageView));
        circle.setStyle(" -fx-background-repeat: no-repeat; -fx-background-size: contain;");
        circle.setTranslateX(20.0D);
        if (imageView != null && !imageView.isError())
            this.mainPane.getChildren().add(circle);

        final Label nameLabel = new Label(projectData.getCustomersData().getName());
        GridPane.setHgrow(nameLabel, Priority.ALWAYS);
        GridPane.setVgrow(nameLabel, Priority.ALWAYS);
        GridPane.setHalignment(nameLabel, HPos.LEFT);
        GridPane.setValignment(nameLabel, VPos.CENTER);
        nameLabel.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 18px; -fx-text-fill: white;");
        nameLabel.setTranslateX(90.0D);
        this.mainPane.getChildren().add(nameLabel);


        final Label priceLabel = new Label(projectData.getPrice() + "€");
        GridPane.setHgrow(priceLabel, Priority.ALWAYS);
        GridPane.setVgrow(priceLabel, Priority.ALWAYS);
        GridPane.setHalignment(priceLabel, HPos.CENTER);
        GridPane.setValignment(priceLabel, VPos.CENTER);
        priceLabel.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 18px; -fx-text-fill: white;");
        this.mainPane.getChildren().add(priceLabel);

        final JFXDatePicker datePicker = new JFXDatePicker(LocalDate.parse(projectData.getDeadLine()));
        GridPane.setHgrow(datePicker, Priority.ALWAYS);
        GridPane.setVgrow(datePicker, Priority.ALWAYS);
        GridPane.setValignment(datePicker, VPos.CENTER);
        GridPane.setHalignment(datePicker, HPos.RIGHT);
        datePicker.getStylesheets().add(Main.class.getResource("/css/datepicker.css").toExternalForm());
        datePicker.setMinSize(200.0D, 30.0D);
        datePicker.setEditable(false);
        datePicker.setTranslateX(-20.0D);
        this.mainPane.getChildren().add(datePicker);

        final MaterialComboBox project_type_combobox = new MaterialComboBox();
        GridPane.setHgrow(project_type_combobox, Priority.ALWAYS);
        GridPane.setVgrow(project_type_combobox, Priority.ALWAYS);
        GridPane.setHalignment(project_type_combobox, HPos.LEFT);
        GridPane.setValignment(project_type_combobox, VPos.TOP);
        project_type_combobox.setTranslateX(30.0D);
        project_type_combobox.setTranslateY(10.0D);
        project_type_combobox.setMaxSize(300.0D, 50.0D);
        project_type_combobox.setDisable(true);
        this.infosPane.getChildren().add(project_type_combobox);

        project_type_combobox.getItems().add(projectData.getProjectEnum().name());
        project_type_combobox.getSelectionModel().select(projectData.getProjectEnum().name());


        final MaterialComboBox project_state_combobox = new MaterialComboBox();
        GridPane.setHgrow(project_state_combobox, Priority.ALWAYS);
        GridPane.setVgrow(project_state_combobox, Priority.ALWAYS);
        GridPane.setHalignment(project_state_combobox, HPos.RIGHT);
        GridPane.setValignment(project_state_combobox, VPos.TOP);
        project_state_combobox.setTranslateY(10.0D);
        project_state_combobox.setTranslateX(-30.0D);
        project_state_combobox.setMaxSize(300.0D, 50.0D);
        this.infosPane.getChildren().add(project_state_combobox);

        for (final ProjectStateEnum projects : ProjectStateEnum.values()) {
            project_state_combobox.getItems().add(projects.name());
        }
        project_state_combobox.getSelectionModel().select(projectData.getProjectStateEnum().name());
        project_state_combobox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            dashBoard.getProjectUtils().updateProject(new ProjectData(ProjectStateEnum.valueOf(newValue), projectData.getProjectEnum(), projectData.getCustomersData(), projectData.getDeadLine(), projectData.getPrice(), projectData.getDescription()));
            System.out.println("Project state changed " + oldValue + " to " + newValue);
        });
    }
}
