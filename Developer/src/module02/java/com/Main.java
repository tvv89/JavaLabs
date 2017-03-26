package module02.java.com;

import module02.java.com.entity.Developer;
import module02.java.com.repository.DeveloperRepo;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        Developer developer1 = new Developer(new Long(1000),"Test1","Test1 surname", new Long(50000));
        DeveloperRepo test = new DeveloperRepo(developer1);
        test.create();
        test.read();
        developer1.setName("Test2");
        test.update();
        test.delete();
    }
}
