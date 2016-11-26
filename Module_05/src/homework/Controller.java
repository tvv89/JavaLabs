package homework;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

import java.util.Set;

/*********************
 ******* task #6 ******
 **********************/

public class Controller {

    public API apis[] = new API[3];

    public Controller(Room[] rooms) {
        this.apis[0] = new BookingComAPI(rooms);
        this.apis[1] = new TripAdvisorAPI(rooms);
        this.apis[2] = new GoogleAPI(rooms);
    }
    public Room[] requestRooms(int price, int persons, String city, String hotel)
    {
        //создаем множество чтоб исключить повторяющиеся
        //изначально оно пустое
        Set<Room> tmp = null;
        //проходим по всем АРІ
        for (int i = 0; i < 3; i++)
        {
            for (Room r_tmp: apis[i].findRooms(price,persons,city,hotel))
            {
                //проходим по всем найденым комнатам
                //и добавляем их во множество
                tmp.add(r_tmp);
            }
        }

        //переводим множество в маcсив
        //поскольку по условию ДЗ нужно получить массив
        Room[] rooms_all = (Room[]) tmp.toArray();

        //возвращаем уже массив
        return rooms_all;
    }
    public Room[] check(API api1, API api2, int price, int persons, String city, String hotel)
    {
        // наверное не понял логику условия
        //здесь я проверяю из найденых по разным апи,
        // и если есть совпадение  - формирую массив
        int count = 0;
        Room[] tmp = null;
        for (Room i:api1.findRooms(price, persons, city, hotel))
        {
            for (Room j:api2.findRooms(price, persons, city, hotel))
            {
                //если комнаты совпадают
                if (i.equals(j))
                {
                    //добавляем в наш временный массив
                    tmp[count] = i;
                    count++;

                }

            }
        }
        return tmp;
    }



}
