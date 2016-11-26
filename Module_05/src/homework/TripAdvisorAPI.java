package homework;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */
/*********************
 ******* task #4 ******
 **********************/
public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] findRooms(int price, int persons, String city, String hotel)
    {
        int tmp_count = 0;
        Room[] tmp = new Room[rooms.length];

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
                tmp[tmp_count] = i;
                tmp_count++;
            }
        }
        return tmp;
    }

}
