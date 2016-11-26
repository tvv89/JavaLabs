package homework;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */
/*********************
 ******* task #7 ******
 **********************/

public class Main {
    public static void main(String[] args)
    {
        Room[] All_app = null;
        //public Room(long id, int price, int persons, Date dateAvailableFrom, String hotelName, String cityName)
        String[] cit = {"London", "Paris", "Lviv", "Kyiv", "NY", "Pekin"};
        for (int i = 0; i <50 ; i++)
        {
            int price = new Random().nextInt(500);
            int persons = new Random().nextInt(5);
            Date dateAvailableFrom = new Date();
            String hotelName = "The best hotel_"+new Random().nextInt(300);
            String cityName = cit[new Random().nextInt(5)];
            All_app[i] = new Room(i,price,persons,dateAvailableFrom,hotelName,cityName);

        }
      //  Controller request = new Controller();
        //DAOImpl test = new DAOImpl();
        //test.save(r);
        System.out.println("Hello! ");
    }
}
