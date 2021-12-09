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

    public CustomersData(final String name, final String email, final String image) {
        this.name = name;
        this.email = email;
        this.image = image;
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

    @Override
    public String toString() {
        return "CustomersData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
