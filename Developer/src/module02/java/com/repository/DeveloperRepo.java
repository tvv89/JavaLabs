package module02.java.com.repository;

import module02.java.com.entity.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepo implements CRUD{
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DATABASE_URL = "jdbc:mysql://localhost:3307/gojava5";
    final String USER = "root";
    final String PASSWORD = "root";
    private Developer developer;
    public List<Developer> select_developers = new ArrayList<>();

    public DeveloperRepo(Developer developer) {
        this.developer = developer;
    }

    @Override
    public void create() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "INSERT INTO developers (developer_id,name,surname,salary) VALUES ("+developer.toSQL().toString()+")";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Override
    public void read() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        statement = connection.createStatement();
        String sql;
        sql = "SELECT * FROM developers";
        ResultSet resultSet = statement.executeQuery(sql);
        select_developers.clear();
        while (resultSet.next()) {
            select_developers.add(new Developer(resultSet.getLong("developer_id"),
            resultSet.getString("name"),
            resultSet.getString("surname"),
            resultSet.getLong("salary")));
        }
        resultSet.close();
        statement.close();
        connection.close();

    }

    @Override
    public void update() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql;
        sql = "UPDATE developers SET developer_id =?,name=?,surname=?,salary=? WHERE developer_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1,developer.getId().intValue());
        statement.setString(2,developer.getName().toString());
        statement.setString(3,developer.getSurname().toString());
        statement.setLong(4,developer.getSalary().longValue());
        statement.setInt(5,developer.getId().intValue());
        int exSQLrows = statement.executeUpdate();
        statement.close();
        connection.close();

    }

    @Override
    public void delete() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql;
        sql = "DELETE FROM developers WHERE developer_id = ?";
        statement = connection.prepareStatement(sql);
        statement.setInt(1,developer.getId().intValue());
        int exSQLrows = statement.executeUpdate();
        statement.close();
        connection.close();

    }
}
