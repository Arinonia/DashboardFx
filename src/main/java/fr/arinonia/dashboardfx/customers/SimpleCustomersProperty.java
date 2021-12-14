package fr.arinonia.dashboardfx.customers;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;

/**
 * @author Arinonia
 * Created at 11/12/2021 - 13:03
 **/
public class SimpleCustomersProperty extends RecursiveTreeObject<SimpleCustomersProperty> {

    private final StringProperty name;
    private final StringProperty email;
    private final ObjectProperty<ImageView> image;
    private final StringProperty date;

    public SimpleCustomersProperty(final String name, final String email, final ImageView image, final String date) {
        this.name =  new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.image = new SimpleObjectProperty<ImageView>(image);
        this.date = new SimpleStringProperty(date);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public ImageView getImage() {
        return image.get();
    }

    public ObjectProperty<ImageView> imageProperty() {
        return image;
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }
}
