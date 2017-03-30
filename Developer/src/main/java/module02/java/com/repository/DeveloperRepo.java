package module02.java.com.repository;

import module02.java.com.entity.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepo{
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3307/gojava5";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public void create(Developer developer) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO developers (developer_id,name,surname,salary) VALUES (" + developer.toSQL().toString() + ")";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
    }

    public List<Developer>  read() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM developers");
        List <Developer> select_developers = new ArrayList<>();
        while (resultSet.next()) {
            select_developers.add(new Developer(resultSet.getLong("developer_id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getLong("salary")));
        }
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
        return select_developers;

    }

    public void update(Developer developer) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "UPDATE developers SET name=?,surname=?,salary=? WHERE developer_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, developer.getName().toString());
        statement.setString(2, developer.getSurname().toString());
        statement.setLong(3, developer.getSalary().longValue());
        statement.setInt(4, developer.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }

    public void delete(Developer developer) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "DELETE FROM developers WHERE developer_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, developer.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }
}
