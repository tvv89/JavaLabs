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

        int tmp_coumt = 0;
        Room[] tmp = new Room[tmp_coumt];

        for (Room i: rooms)
        {
            if (i.getPrice()<=price && i.getPersons()>=persons && i.getHotelName().contains(hotel))
            {
                tmp[tmp_coumt] = i;
                tmp_coumt++;
            }
        }
        return tmp;
    }


}
