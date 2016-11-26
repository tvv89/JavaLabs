package homework;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */
/*********************
 ******* task #5 ******
 **********************/
public interface DAO {
    Room save(Room room);
    boolean delete(Room room);
    Room update(Room room);
    Room findById(long id);
}
