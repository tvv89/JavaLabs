package homework;

import java.util.Date;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */
/*********************
 ******* task #5 ******
 **********************/
public class DAOImpl implements DAO {
    private Room[] rooms;

    public DAOImpl(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room save(Room room)
    {


        rooms[rooms.length] = room;
        System.out.println("save " +room.toString());
      return room;
    }
    public boolean delete(Room room)
    {

        int count = 0;
        //создаем flag для проверки был ли удален элемент
        boolean flag = false;
        // временный пустой массив
        Room[] tmp = new Room[0];
        // гоним по масиву пока не найдем нужный элемент и заодно
        // формируем новый без найденого элемента (если он есть)
        for (Room i: rooms)
        {
            //сравнение по equal
            if (!i.equals(room))
            {
                tmp[count] = i;
                count++;
            }
            else flag = true;
        }
        //переопределяем масив после удаления или
        //даже если не изменился
        rooms = tmp;
        System.out.println("delete " +room.toString());
        return flag;
    }
    public Room update(Room room)
    {
        for (Room i: rooms)
        {
            //сравнение по equal
            if (i.equals(room))
            {
                i.setHotelName(i.getHotelName()+"_update");
                break;
            }

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
            if (i.getId()==id) tmp = i;
        //возыращаем или пустышку или найденый
        System.out.println("findById "+id+" " +tmp.toString());
        return tmp;

    }
}
