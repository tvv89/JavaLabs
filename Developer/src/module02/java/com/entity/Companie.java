package module02.java.com.entity;

public class Companie implements InterfaceSQL {
    Long id;
    String name;
    @Override
    public String toSQL() {
        StringBuffer res = new StringBuffer();
        return res.append(id.toString()).append(", ").append(name).append(", ")
                .toString();
    }
}
