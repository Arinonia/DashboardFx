package fr.arinonia.dashboardfx.ui.panels.home;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;

import fr.arinonia.dashboardfx.Main;
import fr.arinonia.dashboardfx.customers.CustomersData;
import fr.arinonia.dashboardfx.customers.CustomersUtil;
import fr.arinonia.dashboardfx.ui.PanelManager;
import fr.arinonia.dashboardfx.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Arinonia
 * Created at 12/12/2021 - 23:42
 **/
public class AddCustomersPanel extends Panel {

    private File file;

    @Override
    public void init(final PanelManager panelManager) {
        super.init(panelManager);

        final GridPane background = new GridPane();
        GridPane.setHgrow(background, Priority.ALWAYS);
        GridPane.setVgrow(background, Priority.ALWAYS);
        background.setStyle("-fx-background-color: rgba(33, 33, 33, 0.8)");
        this.layout.getChildren().add(background);

        background.setPadding(new Insets(10));

        final MaterialDesignIconView backIcon = new MaterialDesignIconView(MaterialDesignIcon.ARROW_LEFT);
        GridPane.setVgrow(backIcon, Priority.ALWAYS);
        GridPane.setHgrow(backIcon, Priority.ALWAYS);
        GridPane.setHalignment(backIcon, HPos.LEFT);
        GridPane.setValignment(backIcon, VPos.TOP);
        backIcon.setStyle("-fx-font-size: 36px;");
        backIcon.setFill(Color.rgb(200, 200, 200));
        backIcon.setTranslateX(-5.0D);
        backIcon.setCursor(Cursor.HAND);
        backIcon.setOnMouseEntered(e -> backIcon.setFill(Color.rgb(255, 255, 255)));
        backIcon.setOnMouseExited(e -> backIcon.setFill(Color.rgb(200, 200, 200)));
        backIcon.setOnMouseClicked(e -> panelManager.showPanel(this.layout, new CustomersPanel()));
        background.getChildren().add(backIcon);

        final GridPane datePane = new GridPane();
        GridPane.setHgrow(datePane, Priority.ALWAYS);
        GridPane.setVgrow(datePane, Priority.ALWAYS);
        GridPane.setHalignment(datePane, HPos.LEFT);
        GridPane.setValignment(datePane, VPos.TOP);
        datePane.setStyle("-fx-background-color: rgba(44, 44, 44, 0.6); -fx-background-radius: 15px; -fx-border-width: 1px; -fx-border-radius: 15px; -fx-border-color: rgb(0, 150, 136);");
        datePane.setMaxSize(300, 100);
        datePane.setTranslateY(40.0D);
        datePane.setPadding(new Insets(10.0D));
        background.getChildren().add(datePane);


        final Label dateLabel = new Label("Date");
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

        final GridPane namePane = new GridPane();
        GridPane.setHgrow(namePane, Priority.ALWAYS);
        GridPane.setVgrow(namePane, Priority.ALWAYS);
        GridPane.setHalignment(namePane, HPos.CENTER);
        GridPane.setValignment(namePane, VPos.TOP);
        namePane.setStyle("-fx-background-color: rgba(44, 44, 44, 0.6); -fx-background-radius: 15px; -fx-border-width: 1px; -fx-border-radius: 15px; -fx-border-color: rgb(0, 150, 136);");
        namePane.setMaxSize(300, 100);
        namePane.setTranslateY(40.0D);
        background.getChildren().add(namePane);

        final Label nameLabel = new Label("Name");
        GridPane.setHgrow(nameLabel, Priority.ALWAYS);
        GridPane.setVgrow(nameLabel, Priority.ALWAYS);
        GridPane.setValignment(nameLabel, VPos.TOP);
        GridPane.setHalignment(nameLabel, HPos.CENTER);
        nameLabel.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 36px; -fx-text-fill: #FFF");
        namePane.getChildren().add(nameLabel);

        final JFXTextField usernameField = new JFXTextField();
        GridPane.setHgrow(usernameField, Priority.ALWAYS);
        GridPane.setVgrow(usernameField, Priority.ALWAYS);
        GridPane.setValignment(usernameField, VPos.BOTTOM);
        GridPane.setHalignment(usernameField, HPos.CENTER);
        usernameField.setStyle("-jfx-focus-color: rgb(0, 150, 136); -fx-font-size: 18px; -fx-text-fill: white; -fx-font-family: Inconsolata; -fx-prompt-text-fill: rgb(180, 180, 180);");
        usernameField.setTranslateY(-10.0D);
        usernameField.setMaxSize(180.0D, 30.0D);
        usernameField.setPromptText("Username");
        namePane.getChildren().add(usernameField);


        final GridPane emailPane = new GridPane();
        GridPane.setHgrow(emailPane, Priority.ALWAYS);
        GridPane.setVgrow(emailPane, Priority.ALWAYS);
        GridPane.setHalignment(emailPane, HPos.RIGHT);
        GridPane.setValignment(emailPane, VPos.TOP);
        emailPane.setStyle("-fx-background-color: rgba(44, 44, 44, 0.6); -fx-background-radius: 15px; -fx-border-width: 1px; -fx-border-radius: 15px; -fx-border-color: rgb(0, 150, 136);");
        emailPane.setMaxSize(300, 100);
        emailPane.setTranslateY(40.0D);
        background.getChildren().add(emailPane);

        final Label emailLabel = new Label("Email");
        GridPane.setHgrow(emailLabel, Priority.ALWAYS);
        GridPane.setVgrow(emailLabel, Priority.ALWAYS);
        GridPane.setValignment(emailLabel, VPos.TOP);
        GridPane.setHalignment(emailLabel, HPos.CENTER);
        emailLabel.setStyle("-fx-font-family: Inconsolata; -fx-font-size: 36px; -fx-text-fill: #FFF");
        emailPane.getChildren().add(emailLabel);

        final JFXTextField emailField = new JFXTextField();
        GridPane.setHgrow(emailField, Priority.ALWAYS);
        GridPane.setVgrow(emailField, Priority.ALWAYS);
        GridPane.setValignment(emailField, VPos.BOTTOM);
        GridPane.setHalignment(emailField, HPos.CENTER);
        emailField.setStyle("-jfx-focus-color: rgb(0, 150, 136); -fx-font-size: 18px; -fx-text-fill: white; -fx-font-family: Inconsolata; -fx-prompt-text-fill: rgb(180, 180, 180);");
        emailField.setTranslateY(-10.0D);
        emailField.setMaxSize(180.0D, 30.0D);
        emailField.setPromptText("Email");
        emailPane.getChildren().add(emailField);

        final JFXButton choosePic = new JFXButton("Choose profile pic");
        GridPane.setHgrow(choosePic, Priority.ALWAYS);
        GridPane.setVgrow(choosePic, Priority.ALWAYS);
        GridPane.setValignment(choosePic, VPos.CENTER);
        GridPane.setHalignment(choosePic, HPos.CENTER);
        choosePic.setMaxSize(300.0D, 40.0D);
        choosePic.setStyle("-fx-border-color: rgb(0, 150, 136); -fx-border-width: 1px; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-family: Inconsolata;");
        choosePic.setCursor(Cursor.HAND);
        choosePic.setOnMouseClicked(e -> {
            final FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("bite");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png"));
            this.setProfilePic(fileChooser.showOpenDialog(null));
        });
        background.getChildren().add(choosePic);

        final JFXButton addUserButton = new JFXButton("Add customers");
        GridPane.setHgrow(addUserButton, Priority.ALWAYS);
        GridPane.setVgrow(addUserButton, Priority.ALWAYS);
        GridPane.setValignment(addUserButton, VPos.BOTTOM);
        GridPane.setHalignment(addUserButton, HPos.CENTER);
        addUserButton.setMaxSize(200.0D, 40.0D);
        addUserButton.setStyle("-fx-border-color: rgb(0, 150, 136); -fx-border-width: 1px; -fx-font-size: 18px; -fx-text-fill: white; -fx-font-family: Inconsolata");
        addUserButton.setCursor(Cursor.HAND);
        addUserButton.setOnMouseClicked(e -> {

            if (usernameField.getText().isEmpty()) {
                //TODO alert
                return;
            }
            if (emailField.getText().isEmpty()) {
                //TODO alert
                return;
            }
            try {
                if (this.file != null) {
                    final String mimetype = Files.probeContentType(file.toPath());
                    if (mimetype != null && mimetype.split("/")[0].equals("image")) {
                        final File copied = new File(this.panelManager.getDashBoard().getFileManager().getCustomersFolder(), usernameField.getText() + "." + this.file.getName().split("\\.")[this.file.getName().split("\\.").length - 1]);
                        try (
                                InputStream in = new BufferedInputStream(
                                        new FileInputStream(file));
                                OutputStream out = new BufferedOutputStream(
                                        new FileOutputStream(copied))) {

                            byte[] buffer = new byte[1024];
                            int lengthRead;
                            while ((lengthRead = in.read(buffer)) > 0) {
                                out.write(buffer, 0, lengthRead);
                                out.flush();
                            }
                        }

                        final CustomersData customersData = new CustomersData(usernameField.getText(), emailField.getText(), copied.getAbsolutePath(),datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                        new CustomersUtil(panelManager.getDashBoard().getFileManager()).createCustomers(customersData);
                        panelManager.showPanel(this.layout, new CustomersPanel());
                    } else {
                        //I don't know
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        background.getChildren().add(addUserButton);

    }

    private void setProfilePic(final File file) {
        this.file = file;
    }
}
