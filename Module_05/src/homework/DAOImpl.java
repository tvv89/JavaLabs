package homework;

import java.util.Date;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */
/*********************
 ******* task #5 ******
 **********************/
public class DAOImpl implements DAO {
    public Room save(Room room)
    {
      return new Room(1,100,100,new Date(),"Hotel1", "Kiev");
    }
    public boolean delete(Room room)
    {
        return true;
    }
    public Room update(Room room)
    {
        return new Room(1,100,100,new Date(),"Hotel1", "Kiev");
    }
    public Room findById(long id)
    {
        return new Room(1,100,100,new Date(),"Hotel1", "Kiev");
    }
}
