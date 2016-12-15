package hw.module_05;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*********************
 ******* task #6 ******
 **********************/

public class Controller {

    public List<API> apis = new ArrayList<>();

    public Controller(ArrayList<Room> rooms) {
        this.apis.add(new BookingComAPI(rooms));
        this.apis.add(new TripAdvisorAPI(rooms));
        this.apis.add(new GoogleAPI(rooms));
    }
    public Set<Room> requestRooms(int price, int persons, String city, String hotel)
    {
        //создаем множество чтоб исключить повторяющиеся
        //изначально оно пустое
        Set<Room> tmp = new HashSet<Room>();
        //проходим по всем АРІ
        for (int i = 0; i < 3; i++)
        {
            for (Room r_tmp: apis.get(i).findRooms(price,persons,city,hotel))
            {
                //проходим по всем найденым комнатам
                //и добавляем их во множество
                if (r_tmp != null) {
                    tmp.add(r_tmp);
                }

            }
        }

        //возвращаем уже массив
        return tmp;
    }
    public ArrayList<Room> check(API api1, API api2, int price, int persons, String city, String hotel)
    {
        // наверное не понял логику условия
        //здесь я проверяю из найденых по разным апи,
        // и если есть совпадение  - формирую массив

        ArrayList<Room> tmp1 = api1.findRooms(price,persons,city,hotel);
        ArrayList<Room> tmp2 = api2.findRooms(price,persons,city,hotel);
        tmp1.retainAll(tmp2);

        return tmp1;
    }


}
