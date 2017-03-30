package module02.java.com.repository;

import module02.java.com.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3307/gojava5";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public void create(Customer custumer) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO customers (customers_id,customers_name) VALUES (" + custumer.toSQL().toString() + ")";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
    }

    public List<Customer> read() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
        List <Customer> select_customers = new ArrayList<>();
        while (resultSet.next()) {
            select_customers.add(new Customer(resultSet.getLong("customer_id"),
                    resultSet.getString("customer_name")));
        }
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
        return select_customers;

    }

    public void update(Customer customer) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "UPDATE customers SET customers_name=? WHERE customers_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer.getName().toString());
        statement.setInt(2, customer.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }

    public void delete(Customer customer) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "DELETE FROM customers WHERE customers_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, customer.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }
}
