package module02.java.com.repository;

import module02.java.com.entity.Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepo{
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3307/gojava5";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public void create(Project project) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "INSERT INTO projects (project_id,project_name,company_id, custumer_id,cost) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,project.getId().intValue());
        statement.setString(2,project.getName().toString());
        statement.setInt(3,project.getComp_id().intValue());
        statement.setInt(4,project.getCust_id().intValue());
        statement.setDouble(5,project.getCost().doubleValue());
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
    }

    public List<Project> read() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM skills");
        List <Project> select_projects = new ArrayList<>();
        while (resultSet.next()) {
            select_projects.add(new Project(resultSet.getLong("project_id"),
                    resultSet.getString("project_name"),
                    resultSet.getLong("company_id"),
                    resultSet.getLong("customer_id"),
                    resultSet.getDouble("cost")));
        }
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
        return select_projects;

    }

    public void update(Project project) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "UPDATE projects SET project_name=?, company_id=?, customer_id=?, cost=? WHERE project_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, project.getName().toString());
        statement.setLong(2,project.getComp_id().intValue());
        statement.setLong(3,project.getCust_id().intValue());
        statement.setDouble(4,project.getCost().intValue());
        statement.setInt(5, project.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }

    public void delete(Project project) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "DELETE FROM projects WHERE project_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, project.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }


}
