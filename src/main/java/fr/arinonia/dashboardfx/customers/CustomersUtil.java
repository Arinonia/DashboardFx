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

    public ArrayList<CustomersData> loadCustomers(final boolean showMySelf) {
        final ArrayList<CustomersData> customersData = new ArrayList<>();
        final File[] files =  this.fileManager.getCustomersFolder().listFiles();

        if (files != null) {
            for (final File file : files) {
                if (showMySelf && file.getName().endsWith(".customers")) {
                    customersData.add(this.deserializeCustomersData(file));
                } else {
                    if (!file.getName().equals("Me.customers") && file.getName().endsWith(".customers")) {
                        customersData.add(this.deserializeCustomersData(file));
                    }
                }
            }
        }

        return customersData;
    }

    private CustomersData deserializeCustomersData(final File file) {
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
        return  json.fromJson(builder.toString(), CustomersData.class);
    }

    public int getCustomersSize() {
        final File[] files = this.fileManager.getCustomersFolder().listFiles();
        if (files != null)
            return Arrays.stream(files).filter(f -> f.getName().endsWith(".customers")).toArray().length - 1;
        else
            return 0;
    }

    public void createCustomers(final CustomersData customersData) {
        try {
            final FileWriter fw = new FileWriter(new File(this.fileManager.getCustomersFolder(), customersData.getName() + ".customers"));
            this.json.toJson(customersData, fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
