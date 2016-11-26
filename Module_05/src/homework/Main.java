package homework;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */
/*********************
 ******* task #7 ******
 **********************/

public class Main {
    public static void main(String[] args)
    {
        Room[] All_app = new Room[1000];

        String[] cit = {"London", "Paris", "Lviv", "Kyiv", "NY", "Pekin"};
        //формируем базу данных из всех номеров случайным образом
        for (int i = 0; i <All_app.length ; i++)
        {
            //формируем случайные данные
            int price = new Random().nextInt(100)+300;
            int persons = new Random().nextInt(4)+1;
            Date dateAvailableFrom = new Date();
            String hotelName = "The best hotel_"+(new Random().nextInt(30)+1);
            String cityName = cit[new Random().nextInt(6)];
            All_app[i] = new Room(i,price,persons,dateAvailableFrom,hotelName,cityName);

        }
        Controller request = new Controller(All_app);

        System.out.println("-----------request------------");
        for (Room i: request.requestRooms(320,1,"Kyiv","28"))
        {
            System.out.println(i.toString());
        }

        System.out.println("-----------check------------");

        API api1 = new GoogleAPI(All_app);
        API api2 = new TripAdvisorAPI(All_app);

        System.out.println(api1.getClass().getName() + "<---->" + api2.getClass().getName());
        System.out.println();

        Room[] ch_rooms = request.check(api1,api2,320,1,"Kyiv","28");
        int count = 0;
        Room i = ch_rooms[count];

        while (i!=null)
        {
            System.out.println(i.toString());
            count++;
            i = ch_rooms[count];
        }



    }
}
