package hw.module_05;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.util.ArrayList;

/*********************
 ******* task #4 ******
 **********************/
public class TripAdvisorAPI implements API {
    private ArrayList<Room> rooms;

    public TripAdvisorAPI(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> findRooms(int price, int persons, String city, String hotel)
    {
        ArrayList<Room> tmp = new ArrayList<>();

        for (Room i: rooms)
        {
            //сдесь формируются уникальные выборки поиска по
            //комнатам для отображения пользователю
            //интелектуальная выборка

            //если цена в диапазоне +- 100, а количество человек +-1
            //и название отеля содержит, то что в запросе
            //и город который указан в запросе
            if ((i.getPrice()>=price-100)   && (i.getPrice()<=price+100)
             && (i.getPersons()>=persons-1) && (i.getPersons()<=persons+1)
             && i.getHotelName().contains(hotel)
             && i.getCityName().contains(city))
            {
                tmp.add(i);
            }
        }
        return tmp;
    }

}
