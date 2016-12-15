package hw.module_05;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.util.ArrayList;

/*********************
 ******* task #3 ******
 **********************/

public interface API {
     ArrayList<Room> findRooms(int price, int persons, String city, String hotel);
}
