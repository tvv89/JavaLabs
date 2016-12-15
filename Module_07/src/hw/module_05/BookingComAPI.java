package hw.module_05;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.util.ArrayList;

/*********************
 ******* task #4 ******
 **********************/
public class BookingComAPI implements API {
    private ArrayList<Room> rooms;

    public BookingComAPI(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> findRooms(int price, int persons, String city, String hotel)
    {

        int tmp_count = 0;
        Room test = new Room(0,price,persons,null,hotel,city);
        ArrayList<Room>  tmp = new ArrayList<>();
        //сдесь формируются уникальные выборки поиска по
        //комнатам для отображения пользователю
        //тупое/прямолинейное сравнение, чтоб показать использование equals
        for (Room i: rooms)
        {
            if (i.equals(test))
            {
                tmp.add(i);
            }
        }
        return tmp;
    }

}
