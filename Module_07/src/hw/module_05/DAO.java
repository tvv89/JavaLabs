package hw.module_05;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.util.ArrayList;

/*********************
 ******* task #5 ******
 **********************/
public interface DAO {
    Room save(Room room);
    boolean delete(Room room);
    Room update(Room room);
    Room findById(long id);
    ArrayList<Room> getAll();
}
