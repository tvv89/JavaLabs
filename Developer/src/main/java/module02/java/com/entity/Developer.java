package module02.java.com.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Developer implements InterfaceSQL{
    Long id;
    String name;
    String surname;
    Long salary;
    Set<Project> projects = new HashSet<>();
    Set<Skill> skills = new HashSet<>();

    public Developer(Long id, String name, String surname, Long salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String toSQL()
    {
        StringBuffer res = new StringBuffer();
        return res.append(id.toString()).append(", ").append(name).append(", ")
                .append(surname).append(", ").append(salary.toString()).toString();
    }
    public List<String> toSQLProjects()
    {
        List<String> res = new ArrayList<>();
        for (Project i:projects) {
            StringBuffer tmp = new StringBuffer();
            tmp.append(i.toString()).append(", ").append(i.getId().toString());
            res.add(tmp.toString());

        }
        return res;
    }
    public List<String> toSQLSkills()
    {
        List<String> res = new ArrayList<>();
        for (Skill i:skills) {
            StringBuffer tmp = new StringBuffer();
            tmp.append(i.toString()).append(", ").append(i.getId().toString());
            res.add(tmp.toString());

        }
        return res;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
