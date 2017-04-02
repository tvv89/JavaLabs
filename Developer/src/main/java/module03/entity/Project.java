package module03.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "project")
public class Project {
    private int projectId;
    private String projectName;
    private int companyId;
    private int customerId;
    private Double cost;

    public Project() {
    }

    public Project(String projectName, int companyId, int customerId, Double cost) {
        this.projectName = projectName;
        this.companyId = companyId;
        this.customerId = customerId;
        this.cost = cost;
    }

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "project_name")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "cost")
    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectId == project.projectId &&
                companyId == project.companyId &&
                customerId == project.customerId &&
                Objects.equals(projectName, project.projectName) &&
                Objects.equals(cost, project.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectName, companyId, customerId, cost);
    }
}
