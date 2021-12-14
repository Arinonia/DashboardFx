package fr.arinonia.dashboardfx.customers;

import java.io.Serializable;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 02:28
 **/
public class CustomersData implements Serializable {

    private final String name;
    private final String email;
    private final String image;
    private final String date;

    public CustomersData(final String name, final String email, final String image, final String date) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.date = date;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getImage() {
        return this.image;
    }

    public String getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return "CustomersData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
