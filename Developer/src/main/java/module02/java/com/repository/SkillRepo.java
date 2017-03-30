package module02.java.com.repository;

import module02.java.com.entity.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillRepo {
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE_URL = "jdbc:mysql://localhost:3307/gojava5";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public void create(Skill skill) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO skills (skill_id,skill_name) VALUES (" + skill.toSQL().toString() + ")";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
    }

    public List<Skill> read() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM skills");
        List <Skill> select_skills = new ArrayList<>();
        while (resultSet.next()) {
            select_skills.add(new Skill(resultSet.getLong("skill_id"),
                    resultSet.getString("skills_name")));
        }
        resultSet.close();
        statement.close();
        connection.commit();
        connection.close();
        return select_skills;

    }

    public void update(Skill skill) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "UPDATE skills SET skill_name=? WHERE skill_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, skill.getName().toString());
        statement.setInt(2, skill.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }

    public void delete(Skill skill) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        String sql = "DELETE FROM skills WHERE skill_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, skill.getId().intValue());
        statement.executeUpdate();
        statement.close();
        connection.commit();
        connection.close();
    }

}
