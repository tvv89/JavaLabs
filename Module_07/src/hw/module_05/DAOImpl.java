package hw.module_05;



/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.util.ArrayList;

/*********************
 ******* task #5 ******
 **********************/
public class DAOImpl implements DAO {
    private ArrayList<Room> rooms;

    public DAOImpl(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Room save(Room room)
    {
        rooms.add(room);
        System.out.println("save " +room.toString());
      return room;
    }
    public boolean delete(Room room)
    {
        return rooms.remove(room);
    }
    public Room update(Room room)
    {
        for (Room i: rooms) {
            if (i.equals(room)) i.setHotelName("new HotelName");

        }
        System.out.println("update " +room.toString());
        return room;
    }
    public Room findById(long id)
    {
        //создаем пустышку
        Room tmp = new Room(0,0,0,null,null,null);
        for (Room i: rooms)
            //если нашли то меняем пустышку на найденый элемент
            if (i.getId()==id)
            {
                tmp = i;
                break;
            }
        //возыращаем или пустышку или найденый
        System.out.println("findById "+id+" " + tmp);
        return tmp;

    }

    /*********************
     ******* task #9 ******
     **********************/
    //возвращаем всю входящую базу данных
    public ArrayList<Room> getAll() {
        return rooms;
    }
}
