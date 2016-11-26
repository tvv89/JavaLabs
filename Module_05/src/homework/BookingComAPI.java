package homework;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */
/*********************
 ******* task #4 ******
 **********************/
public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    public Room[] findRooms(int price, int persons, String city, String hotel)
    {

        int tmp_count = 0;
        Room test = new Room(0,price,persons,null,hotel,city);
        Room[] tmp = new Room[rooms.length];

        for (Room i: rooms)
        {
            if (i.equals(test))
            {
                tmp[tmp_count] = i;
                tmp_count++;
            }
        }
        return tmp;
    }

}
