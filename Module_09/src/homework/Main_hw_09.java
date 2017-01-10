package homework;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Volodymyr Tymchuk on 10.01.2017 for JavaLabs.
 */
public class Main_hw_09 {
    public static void main(String[] args) {
        //заготовка для формирования пользователей, валюты и городов
        //это используется только для проверки/автозаполнения
        //чтоб не вводить все в ручную для каждого пользователя и заявки
        String[] cities = {"Kiev", "London", "NY", "Paris", "Lviv"};
        Order.Currency[] curr = {Order.Currency.EUR, Order.Currency.USD, Order.Currency.UAH};
        String[] userLastName = {"Ivanov", "Petrov", "Sidorov", "Smit", "Valera"};

        List<Order> DBtrans = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User usrTMP = new User(10000 + i, "User Name_" + i, userLastName[new Random().nextInt(5)], cities[i % 5], 1000 + i * 100);
            Order ordTMP = new Order(1000000 + i, 1475 + (new Random().nextInt(50)), curr[i % 3], "Product_" + (new Random().nextInt(20)), "shopIdentificator_" + (i + 37), usrTMP);
            DBtrans.add(ordTMP);
        }

        PriceDesc(DBtrans);
        PriceAcs(DBtrans);
        SortListNIC(DBtrans);
        DeleteDublicate(DBtrans);
        Delete1500(DBtrans);
        TwoListCurr(DBtrans);

        Map<String,List<Order>> MoreList = MapList(DBtrans);

        FindPetrov(DBtrans);
        DeleteUSD(DBtrans);

    }

    //-отсортируйте список за ценой заказа по убыванию
    public static void PriceDesc(List<Order> DBtrans) {
        DBtrans.stream().sorted((i, j)->Integer.compare(j.getPrice(),i.getPrice())).collect(Collectors.toList()).forEach(System.out::println);
    }

    //-отсортируйте список за ценой заказа по возрастанию и за городом пользователя
    public static void PriceAcs(List<Order> DBtrans) {
     DBtrans.stream().sorted((i,j)->{

            int result = i.getPrice()-j.getPrice();  //выполняется сравнение
            if (result!=0) return result;
            result = i.getUser().getCity().compareTo(j.getUser().getCity());
            return result;

        }).collect(Collectors.toList()).forEach(System.out::println);
    }

    //-отсортируйте список за наименованием товара, идентификатором заказа, и городом пользователя
    public static void SortListNIC(List<Order> DBtrans) {
        DBtrans.stream().sorted((i, j) -> {

            int result = i.getItemName().compareTo(j.getItemName());  //выполняется сравнение и возврат наименьшего элемента
            if (result != 0) return result;
            result = i.getShopIdentificator().compareTo(j.getShopIdentificator());
            if (result != 0) return result;
            result = i.getUser().getCity().compareTo(j.getUser().getCity());
            if (result != 0) return result;
            return result;


        }).collect(Collectors.toList()).forEach(System.out::println);
    }

    //-удалите дублированные данные со списка
    public static void DeleteDublicate(List<Order> DBtrans) {
            DBtrans.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    //-удалите объекты, где цена меньше 1500
    public static void Delete1500(List<Order> DBtrans) {
            DBtrans.stream().filter(i->i.getPrice()>1500).collect(Collectors.toList()).forEach(System.out::println);
    }

    //-разделите список на 2 списка - заказы в долларах и в гривнах
    public static void TwoListCurr(List<Order> DBtrans) {
        System.out.println("-----------USD-----------");
        DBtrans.stream().filter(i -> i.getCurrency().equals(Order.Currency.USD)).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-----------UAH-----------");
        DBtrans.stream().filter(i -> i.getCurrency().equals(Order.Currency.UAH)).collect(Collectors.toList()).forEach(System.out::println);
    }

    //        -разделите список на столько списков, сколько уникальных городов в User
    public static Map<String,List<Order>> MapList(List<Order> DBtrans) {
        return DBtrans.stream().collect(Collectors.groupingBy(i -> i.getUser().getCity()));
    }

    //-проверьте, содержит ли сет заказ, где фамилия пользователя - “Petrov”
    public static void FindPetrov(List<Order> DBtrans) {
        DBtrans.stream().filter(i -> i.getUser().getLastName().contains("Petrov")).collect(Collectors.toList()).forEach(System.out::println);
    }

    //-удалите заказы в USD
    public static void DeleteUSD(List<Order> DBtrans) {
        DBtrans.stream().filter(i->i.getCurrency()!= Order.Currency.USD).collect(Collectors.toList()).forEach(System.out::println);
    }

}
