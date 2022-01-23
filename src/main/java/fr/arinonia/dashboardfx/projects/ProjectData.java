package fr.arinonia.dashboardfx.projects;

import fr.arinonia.dashboardfx.customers.CustomersData;

import java.io.Serializable;

/**
 * @author Arinonia
 * Created at 22/01/2022 - 02:32
 **/
public class ProjectData implements Serializable {

    private final ProjectStateEnum projectStateEnum;
    private final ProjectEnum projectEnum;
    private final CustomersData customersData;
    private final String deadLine;
    private final String price;
    private final String description;

    public ProjectData(final ProjectStateEnum projectStateEnum, final ProjectEnum projectEnum, final CustomersData customersData, final String deadLine, final String price, final String description) {
        this.projectStateEnum = projectStateEnum;
        this.projectEnum = projectEnum;
        this.customersData = customersData;
        this.deadLine = deadLine;
        this.price = price;
        this.description = description;
    }

    public ProjectStateEnum getProjectStateEnum() {
        return this.projectStateEnum;
    }

    public ProjectEnum getProjectEnum() {
        return this.projectEnum;
    }

    public CustomersData getCustomersData() {
        return this.customersData;
    }

    public String getDeadLine() {
        return this.deadLine;
    }

    public String getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "ProjectData{" +
                "projectStateEnum=" + projectStateEnum +
                ", projectEnum=" + projectEnum +
                ", customersData=" + customersData +
                ", deadLine='" + deadLine + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


