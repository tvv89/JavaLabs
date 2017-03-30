package module02.java.com;

import module02.java.com.entity.Developer;
import module02.java.com.repository.DeveloperRepo;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        Developer developer1 = new Developer(new Long(1000),"Test1","Test1 surname", new Long(50000));
        DeveloperRepo test = new DeveloperRepo();
        test.create(developer1);
        List<Developer> result = test.read();
        developer1.setName("Test2");
        test.update(developer1);
        test.delete(developer1);
    }
}
