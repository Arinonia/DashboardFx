package fr.arinonia.dashboardfx.projects;


import com.google.gson.Gson;
import fr.arinonia.dashboardfx.file.FileManager;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Arinonia
 * Created at 23/01/2022 - 03:48
 **/
public class ProjectUtil {

    private final Gson json = new Gson();
    private final FileManager fileManager;

    public ProjectUtil(final FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public ArrayList<ProjectData> loadProjects() {
        final ArrayList<ProjectData> projectData = new ArrayList<>();
        final File[] files =  this.fileManager.getProjectsFolder().listFiles();

        if (files != null) {
            for (final File file : files) {
                if (file.getName().endsWith(".projects")) {

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
                    projectData.add(json.fromJson(builder.toString(), ProjectData.class));
                }
            }
        }

        return projectData;
    }

    public void createCustomers(final ProjectData projectData) {
        try {
            final FileWriter fw = new FileWriter(new File(this.fileManager.getProjectsFolder(), projectData.getCustomersData().getName() + ".projects"));
            this.json.toJson(projectData, fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateProject(final ProjectData projectData) {
        try {
            final FileWriter fw = new FileWriter(new File(this.fileManager.getProjectsFolder(), projectData.getCustomersData().getName() + ".projects"));
            fw.write("");
            this.json.toJson(projectData, fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
