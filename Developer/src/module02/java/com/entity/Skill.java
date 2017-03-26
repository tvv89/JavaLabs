package module02.java.com.entity;

public class Skill implements InterfaceSQL {
    Long id;
    String name;

    @Override
    public String toSQL() {
        StringBuffer res = new StringBuffer();
        return res.append(id.toString()).append(", ").append(name).append(", ")
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
}
