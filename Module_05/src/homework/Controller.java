package homework;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.util.Date;

/*********************
 ******* task #6 ******
 **********************/

public class Controller {

    public API apis[] = new API[3];

    public Controller() {
        this.apis[0] = new BookingComAPI();
        this.apis[1] = new TripAdvisorAPI();
        this.apis[2] = new GoogleAPI();
    }
    public Room[] requestRooms(int price, int persons, String city, String hotel)
    {
        Room[] tmp = new Room[2];
        tmp[0] = new Room(1,100,100,new Date(),"Hotel1", "Kiev");
        tmp[1] = new Room(2,100,100,new Date(),"Hotel2", "Kiev");
        return tmp;
    }
    public Room[] check(API api1, API api2)
    {
        Room[] tmp = new Room[2];
        tmp[0] = new Room(1,100,100,new Date(),"Hotel1", "Kiev");
        tmp[1] = new Room(2,100,100,new Date(),"Hotel2", "Kiev");
        return tmp;
    }



}
