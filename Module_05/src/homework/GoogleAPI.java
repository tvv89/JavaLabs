package homework;

import java.math.RoundingMode;
import java.util.Date;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */
/*********************
 ******* task #4 ******
 **********************/
public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] findRooms(int price, int persons, String city, String hotel)
    {

        int tmp_count = 0;
        Room[] tmp = new Room[rooms.length];

        for (Room i: rooms)
        {
            //здесь мы формируем список
            //интелектуальная выборка

            //если цена ниже, а количество человек больше
            //и название отеля содержит то что в запросе
            //и город который указан в запросе
            if (i.getPrice()<=price && i.getPersons()>=persons
                && i.getHotelName().contains(hotel)
                && i.getCityName().contains(city))
            {
                tmp[tmp_count] = i;
                tmp_count++;
            }
        }
        return tmp;
    }


}
