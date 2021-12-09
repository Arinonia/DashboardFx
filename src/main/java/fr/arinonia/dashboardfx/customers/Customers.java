package fr.arinonia.dashboardfx.customers;


import com.google.gson.Gson;
import fr.arinonia.dashboardfx.file.FileManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Arinonia
 * Created at 08/12/2021 - 02:57
 **/
public class Customers {

    private final Gson json = new Gson();
    private final FileManager fileManager;

    public Customers(final FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public CustomersData loadCustomer(final String name) {
        try {
            final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(this.fileManager.getCustomersFolder(), name + ".customers")));
            return (CustomersData) ois.readObject();
        } catch (final IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CustomersData> loadCustomers() {
        final ArrayList<CustomersData> customersData = new ArrayList<>();

        return customersData;
    }

    public int getCustomersSize() {
        return Arrays.stream(this.fileManager.getCustomersFolder().listFiles()).filter(f -> f.getName().endsWith(".customers")).toArray().length - 1;
    }

    public void createCustomers(final CustomersData customersData) {
        try {
            FileWriter fw = new FileWriter(new File(this.fileManager.getCustomersFolder(), customersData.getName() + ".customers"));
            this.json.toJson(customersData, fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
