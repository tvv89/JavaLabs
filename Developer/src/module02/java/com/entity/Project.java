package module02.java.com.entity;

public class Project implements InterfaceSQL{
    Long id;
    String name;
    Long comp_id;
    Long cust_id;
    Long cost;

    @Override
    public String toSQL() {
        StringBuffer res = new StringBuffer();
        return res.append(id.toString()).append(", ")
                .append(name).append(", ")
                .append(comp_id.toString()).append(", ")
                .append(cust_id.toString()).append(", ")
                .append(cost.toString()).append(", ")
                .toString();
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

    public Long getComp_id() {
        return comp_id;
    }

    public void setComp_id(Long comp_id) {
        this.comp_id = comp_id;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
