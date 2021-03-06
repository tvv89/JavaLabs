package hw.module_05;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

        ArrayList<Room> All_app = new ArrayList<>();

        String[] cit = {"London", "Paris", "Lviv", "Kyiv", "NY", "Pekin"};
        //формируем базу данных из всех номеров случайным образом
        for (int i = 0; i <1000 ; i++)
        {
            //формируем случайные данные
            int price = new Random().nextInt(100)+300;
            int persons = new Random().nextInt(4)+1;
            Date dateAvailableFrom = new Date();
            String hotelName = "The best hotel_"+(new Random().nextInt(30)+1);
            String cityName = cit[new Random().nextInt(6)];
            All_app.add(new Room(i,price,persons,dateAvailableFrom,hotelName,cityName));

        }
        Controller request = new Controller(All_app);

        System.out.println("----------- request #1 ------------");
        for (Room i: request.requestRooms(320,1,"Kyiv","28"))
        {
            System.out.println(i.toString());
        }
        System.out.println("----------- request #2 ------------");
        for (Room i: request.requestRooms(350,2,"London","15"))
        {
            System.out.println(i.toString());
        }
        System.out.println("----------- request #3 ------------");
        for (Room i: request.requestRooms(370,4,"NY","4"))
        {
            System.out.println(i.toString());
        }

        //проверка три раза с разными методами на одни и те же параметры
        for (int i = 0; i < 3; i++) {
            API api1 = new BookingComAPI(All_app);
            API api2 = new TripAdvisorAPI(All_app);
            API api3 = new GoogleAPI(All_app);
            ArrayList<Room> ch_rooms = new ArrayList<>();
            System.out.println("----------- check #"+(i+1)+" ------------");

            if (i==0)
            {
                System.out.println(">>>"+api1.getClass().getName() + "<---->" + api2.getClass().getName());
                ch_rooms = request.check(api1,api2,320,1,"Kyiv","28");
            }
            if (i==1)
            {
                System.out.println(">>>"+api1.getClass().getName() + "<---->" + api3.getClass().getName());
                ch_rooms = request.check(api1,api3,320,1,"Kyiv","28");
            }
            if (i==2)
            {
                System.out.println(">>>"+api2.getClass().getName() + "<---->" + api3.getClass().getName());
                ch_rooms = request.check(api2,api3,320,1,"Kyiv","28");
            }

            Iterator<Room> iterator = ch_rooms.iterator();
            while (iterator.hasNext())
            {
                System.out.println(iterator.next().toString());
            }

        }


    }
}
