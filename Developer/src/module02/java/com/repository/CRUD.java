package module02.java.com.repository;

import java.sql.SQLException;

public interface CRUD {
    void  create() throws ClassNotFoundException, SQLException;
    void  read() throws ClassNotFoundException, SQLException;
    void  update() throws ClassNotFoundException, SQLException;
    void  delete() throws ClassNotFoundException, SQLException;

}
