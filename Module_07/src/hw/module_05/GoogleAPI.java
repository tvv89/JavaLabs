package hw.module_05;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.util.ArrayList;

/*********************
 ******* task #4 ******
 **********************/
public class GoogleAPI implements API {
    private ArrayList<Room> rooms;

    public GoogleAPI(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> findRooms(int price, int persons, String city, String hotel)
    {
        ArrayList<Room> tmp = new ArrayList<>();

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
                tmp.add(i);
            }
        }
        return tmp;
    }


}
