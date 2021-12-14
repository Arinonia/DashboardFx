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
public class CustomersUtil {

    private final Gson json = new Gson();
    private final FileManager fileManager;

    public CustomersUtil(final FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public CustomersData loadCustomer(final String name) {
        System.out.println("empty methode");
        return null;
    }

    public ArrayList<CustomersData> loadCustomers() {
        final ArrayList<CustomersData> customersData = new ArrayList<>();
        final File[] files =  this.fileManager.getCustomersFolder().listFiles();

        if (files != null) {
            for (final File file : files) {
                if (!file.getName().equals("Me.customers") && file.getName().endsWith(".customers")) {

                    final StringBuilder builder = new StringBuilder();

                    try (final FileReader fileStream = new FileReader(file);
                        final BufferedReader bufferedReader = new BufferedReader(fileStream)) {

                        String line;

                        while( (line = bufferedReader.readLine()) != null ) {
                            builder.append(line);
                        }

                    } catch (IOException ex) {
                        //exception Handling
                    }
                    customersData.add(json.fromJson(builder.toString(), CustomersData.class));
                }
            }
        }

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
