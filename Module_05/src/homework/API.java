package homework;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

/*********************
 ******* task #3 ******
 **********************/

public interface API {
     Room[] findRooms (int price, int persons, String city, String hotel);
}
