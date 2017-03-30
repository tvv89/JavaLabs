package module02.java.com.repository;

import module02.java.com.entity.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepo {
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3307/gojava5";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public void create(Company company) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO companies (company_id,company_name) VALUES (" + company.toSQL().toString() + ")";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
    }

    public List<Company> read() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM companies");
        List <Company> select_companies = new ArrayList<>();
        while (resultSet.next()) {
            select_companies.add(new Company(resultSet.getLong("company_id"),
                    resultSet.getString("company_name")));
        }
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
        return select_companies;

    }

    public void update(Company company) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "UPDATE companies SET company_name=? WHERE company_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, company.getName().toString());
        statement.setInt(2, company.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }

    public void delete(Company company) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "DELETE FROM companies WHERE company_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, company.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }
}
