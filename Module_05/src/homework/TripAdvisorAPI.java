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
        Room[] tmp = new Room[tmp_count];

        for (Room i: rooms)
        {
            //сдесь формируются уникальные выборки поиска по
            //комнтатам для отображения пользователю
            if ((i.getPrice()>=price-100)   && (i.getPrice()<=price+100)
             && (i.getPersons()>=persons-1) && (i.getPersons()<=persons+1)
             && i.getHotelName().contains(hotel))
            {
                tmp[tmp_count] = i;
                tmp_count++;
            }
        }
        return tmp;
    }

}
