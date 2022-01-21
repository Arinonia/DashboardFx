package fr.arinonia.dashboardfx.ui.controls;

import com.jfoenix.controls.JFXDatePicker;
import fr.arinonia.dashboardfx.Main;
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
 * Created at 13/12/2021 - 22:36
 **/
public class CustomersCard extends Card {

    public CustomersCard(final String name, final String email, final String image, final String date) {
        super();
        //TODO put default user pic if image is null
        final Circle circle = new Circle(0, 0, 25);
        final Image imageView = new Image("file:///" + image.replaceAll("\\\\", "/"));
        circle.setFill(new ImagePattern(imageView));
        circle.setStyle(" -fx-background-repeat: no-repeat; -fx-background-size: contain;");
        circle.setTranslateX(20.0D);
        if (imageView != null && !imageView.isError())
            this.mainPane.getChildren().add(circle);


        final Label nameLabel = new Label(name);
        GridPane.setHgrow(nameLabel, Priority.ALWAYS);
        GridPane.setVgrow(nameLabel, Priority.ALWAYS);
        GridPane.setHalignment(nameLabel, HPos.LEFT);
        GridPane.setValignment(nameLabel, VPos.CENTER);
        nameLabel.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 18px; -fx-text-fill: white;");
        nameLabel.setTranslateX(100.0D);
        this.mainPane.getChildren().add(nameLabel);

        final Label emailLabel = new Label(email);
        GridPane.setHgrow(emailLabel, Priority.ALWAYS);
        GridPane.setVgrow(emailLabel, Priority.ALWAYS);
        GridPane.setHalignment(emailLabel, HPos.CENTER);
        GridPane.setValignment(emailLabel, VPos.CENTER);
        emailLabel.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 18px; -fx-text-fill: white;");
        this.mainPane.getChildren().add(emailLabel);

        final JFXDatePicker datePicker = new JFXDatePicker(LocalDate.parse(date));
        GridPane.setHgrow(datePicker, Priority.ALWAYS);
        GridPane.setVgrow(datePicker, Priority.ALWAYS);
        GridPane.setValignment(datePicker, VPos.CENTER);
        GridPane.setHalignment(datePicker, HPos.RIGHT);
        datePicker.getStylesheets().add(Main.class.getResource("/css/datepicker.css").toExternalForm());
        datePicker.setMinSize(200.0D, 30.0D);
        datePicker.setEditable(false);
        datePicker.setTranslateX(-20.0D);
        this.mainPane.getChildren().add(datePicker);
    }
}
