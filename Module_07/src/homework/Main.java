package homework;

import java.util.*;

/**
 * Created by Volodymyr Tymchuk on 12.12.2016 for JavaLabs.
 */
public class Main {
    //для решения задачи по вычислению времени созданы функции
    //для простоты передаем сюда общий List<> и количество уже созданых элементов чтоб побольше унифицировать
    //поскольку мы Дженерики не проходили - еще больше унифицировать не получилось

    //ADD
    public static long Integer_time_exec(List<Integer> inList,long count, String methodName)
    {
        inList.clear();
        for (int i = 0; i <count ; i++) {
            inList.add(i);
        }
        long start=0;
        long end=0;

        if (methodName.contains("add")) {
            start = System.nanoTime();
            inList.add(100);
            end = System.nanoTime();
        }
        if (methodName.contains("set")) {
            start = System.nanoTime();
            inList.set(50,200);
            end = System.nanoTime();
        }
        if (methodName.contains("get")) {
            start = System.nanoTime();
            inList.get(50);
            end = System.nanoTime();
        }
        if (methodName.contains("remove")) {
            start = System.nanoTime();
            inList.remove(50);
            end = System.nanoTime();
        }

        return end-start;
    }
    public static long String_time_exec(List<String> inList, long count,String methodName)
    {
        inList.clear();
        for (int i = 0; i <count ; i++) {
            inList.add("line_"+i);
        }
        long start=0;
        long end=0;

        if (methodName.contains("add")) {
            start = System.nanoTime();
            inList.add("100");
            end = System.nanoTime();
        }
        if (methodName.contains("set")) {
            start = System.nanoTime();
            inList.set(50,"200");
            end = System.nanoTime();
        }
        if (methodName.contains("get")) {
            start = System.nanoTime();
            inList.get(50);
            end = System.nanoTime();
        }
        if (methodName.contains("remove")) {
            start = System.nanoTime();
            inList.remove(50);
            end = System.nanoTime();
        }

        return end-start;
    }



    public static void main(String[] args) {
        //заготовка для формирования пользователей, валюты и городов
        //это используется только для проверки/автозаполнения
        //чтоб не вводить все в русную для каждого пользователя и заявки
        String[] cities = {"Kiev", "London", "NY", "Paris", "Lviv"};
        Order.Currency[] curr = {Order.Currency.EUR, Order.Currency.USD, Order.Currency.UAH};
        String [] userLastName = {"Ivanov", "Petrov", "Sidorov","Smit", "Valera"};
        /* -------------------------
        ---------- task #2 ---------
        ----------------------------*/
        List<Order> DBtrans = new ArrayList<Order>();
        for (int i = 0; i <10 ; i++) {
            User usrTMP = new User("User Name_"+i, userLastName[new Random().nextInt(5)], cities[i%5], 1000+i*100);
            Order ordTMP = new Order(1000000+i,1475+ (new Random().nextInt(50)), curr[i%3],"Product_"+(new Random().nextInt(20)),"shopIdentificator_"+(i+37),usrTMP);
            DBtrans.add(ordTMP);
        }

        //использование компаратора для демонстрации и обучения
        //чтоб понять как он работает (несколько часов вникал в суть)
        //позже буду конкретно упрощать работу с компаратором
        //сортировка по полям price
        Collections.sort(DBtrans,new Comparator(){
            public int compare(Object o1, Object o2) {
                Order tmp1  = (Order) o1;
                Order tmp2  = (Order) o2;
                int result = tmp2.getPrice()-tmp1.getPrice();  //выполняется сравнение
                return result;
            }
        });

        //сортировка по price AND User.city
        //не обязательно поскольку в классе переопределено compareTo пот єто условие
        Collections.sort(DBtrans,new Comparator(){
            public int compare(Object o1, Object o2) {
                Order tmp1  = (Order) o1;
                Order tmp2  = (Order) o2;
                int result = tmp1.getPrice()-tmp2.getPrice();  //выполняется сравнение
                if (result!=0) return result;
                result = tmp1.getUser().getCity().compareTo(tmp2.getUser().getCity());
                return result;
            }
        });
        //сортировка компаратором по полям ItemName  ShopIdentificator  city
        Collections.sort(DBtrans,new Comparator(){
            public int compare(Object o1, Object o2) {
                Order tmp1  = (Order) o1;
                Order tmp2  = (Order) o2;
                int result = tmp1.getItemName().compareTo(tmp2.getItemName());  //выполняется сравнение и возврат наименьшего элемента
                if (result!=0) return result;
                result = tmp1.getShopIdentificator().compareTo(tmp2.getShopIdentificator());
                if (result!=0) return result;
                result = tmp1.getUser().getCity().compareTo(tmp2.getUser().getCity());
                if (result!=0) return result;
                return result;
            }
        });

        //удалить повторяющиеся элементы из List
        Set<Order> unicList = new HashSet<>(DBtrans);
        DBtrans.clear();
        DBtrans.addAll(unicList);

        //удалить элементы с ценой ниже 1500
        //примитивный обход по всех значениях коллекции
        for (int i=0; i<DBtrans.size();i++)
        {
            if (DBtrans.get(i).getPrice()<1500) DBtrans.remove(i);
        }

        //примитивное создание двух листов в зависимости от ВАЛЮТЫ
        //без использования итераторов и Map-ов
        Map<Order.Currency,List<Order>> separateCurrency = new HashMap<Order.Currency,List<Order>>();
        List<Order> listUSD = new ArrayList<Order>();
        List<Order> listUAH = new ArrayList<Order>();
        for (Order i:DBtrans)
        {
            if (i.getCurrency()== Order.Currency.USD)listUSD.add(i);
            if (i.getCurrency()== Order.Currency.UAH)listUSD.add(i);
        }
        separateCurrency.put(Order.Currency.USD,listUSD);
        separateCurrency.put(Order.Currency.UAH,listUAH);

        //создание списков с уникальными городами используя принцип DRY
        //без использования итераторов но с использованием Map, для упрощения
        // и избыточности кода
        Map<String,List<Order>> separateCities = new HashMap<>();
        for (Order i: DBtrans)
        {
            if(separateCities.containsKey(i.getUser().getCity())) {
                separateCities.get(i.getUser().getCity()).add(i);
            } else {
                List<Order> newList = new ArrayList<>();
                newList.add(i);
                separateCities.put(i.getUser().getCity(), newList);
            }
        }

        /* -------------------------
        ---------- task #3 ---------
        ----------------------------*/
        TreeSet<Order> OrderForSet = new TreeSet<>();
        List<User> usersList  = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            usersList.add(new User("User Name_"+i, userLastName[new Random().nextInt(5)], cities[i%5], 1000+i*100));
        }
        //уникальные заказы
        OrderForSet.add(new Order(1000001,1600, Order.Currency.EUR,"Product_1","shopIdentificator_1",usersList.get(1)));
        OrderForSet.add(new Order(1000002,1700, Order.Currency.USD,"Product_2","shopIdentificator_2",usersList.get(2)));
        OrderForSet.add(new Order(1000003,1800, Order.Currency.UAH,"Product_3","shopIdentificator_3",usersList.get(3)));
        OrderForSet.add(new Order(1000004,1900, Order.Currency.EUR,"Product_4","shopIdentificator_4",usersList.get(4)));
        OrderForSet.add(new Order(1000005,1100, Order.Currency.USD,"Product_5","shopIdentificator_5",usersList.get(5)));
        OrderForSet.add(new Order(1000006,1200, Order.Currency.UAH,"Product_6","shopIdentificator_6",usersList.get(6)));
        OrderForSet.add(new Order(1000007,1300, Order.Currency.EUR,"Product_7","shopIdentificator_7",usersList.get(7)));
        OrderForSet.add(new Order(1000008,1400, Order.Currency.USD,"Product_8","shopIdentificator_8",usersList.get(8)));
        //повторяющиеся заказы
        OrderForSet.add(new Order(1000009,1500, Order.Currency.UAH,"Product_9","shopIdentificator_9",usersList.get(9)));
        OrderForSet.add(new Order(1000009,1500, Order.Currency.UAH,"Product_9","shopIdentificator_9",usersList.get(9)));

        //присутствует ли элемант с пользователем с фамилией "Petrov"
        for (Order i:OrderForSet)
        {
            if (i.getUser().getLastName().contains("Petrov"))
            {
                System.out.println("TreeSet contain Petrov is user.lastname");
                break;
            }
        }

        //отобразить елемент с наибольшей ценой
        //не понял условие "- print Order with largest price using only one set method - get "
        //поскольку мы и так сделали для Order compareTo по цене,
        //а для TreeSet, который самоупорядочивается, последний элемент и будет с максимальной ценой
        //и где тут брать один метод "GET"???
        System.out.println(OrderForSet.last().toString());


        /* -------------------------
        ---------- task #5 ---------
        ----------------------------*/
        // Вычисление времени для
       List<Integer> Int_timeAL = new ArrayList<>();
        List<Integer> Int_timeLL = new LinkedList<>();
        List<String> Str_timeAL = new ArrayList<>();
        List<String> Str_timeLL = new LinkedList<>();
        //результаты в наносекундах
        System.out.println("Integer");
        System.out.println("Add Integer to ArrayList 1000       ----> "+Integer_time_exec(Int_timeAL,1000,"add"));
        System.out.println("Add Integer to ArrayList 1000000    ----> "+Integer_time_exec(Int_timeAL,1000000,"add"));
        System.out.println("Add Integer to LinkedList 1000      ----> "+Integer_time_exec(Int_timeLL,1000,"add"));
        System.out.println("Add Integer to LinkedList 1000000   ----> "+Integer_time_exec(Int_timeLL,1000000,"add"));
        System.out.println("Set Integer to ArrayList 1000       ----> "+Integer_time_exec(Int_timeAL,1000,"set"));
        System.out.println("Set Integer to ArrayList 1000000    ----> "+Integer_time_exec(Int_timeAL,1000000,"set"));
        System.out.println("Set Integer to LinkedList 1000      ----> "+Integer_time_exec(Int_timeLL,1000,"set"));
        System.out.println("Set Integer to LinkedList 1000000   ----> "+Integer_time_exec(Int_timeLL,1000000,"set"));
        System.out.println("Get Integer to ArrayList 1000       ----> "+Integer_time_exec(Int_timeAL,1000,"get"));
        System.out.println("Get Integer to ArrayList 1000000    ----> "+Integer_time_exec(Int_timeAL,1000000,"get"));
        System.out.println("Get Integer to LinkedList 1000      ----> "+Integer_time_exec(Int_timeLL,1000,"get"));
        System.out.println("Get Integer to LinkedList 1000000   ----> "+Integer_time_exec(Int_timeLL,1000000,"get"));
        System.out.println("Remove Integer to ArrayList 1000    ----> "+Integer_time_exec(Int_timeAL,1000,"remove"));
        System.out.println("Remove Integer to ArrayList 1000000 ----> "+Integer_time_exec(Int_timeAL,1000000,"remove"));
        System.out.println("Remove Integer to LinkedList 1000   ----> "+Integer_time_exec(Int_timeLL,1000,"remove"));
        System.out.println("Remove Integer to LinkedList 1000000----> "+Integer_time_exec(Int_timeLL,1000000,"remove"));

        System.out.println("String");
        System.out.println("Add String to ArrayList 1000        ----> "+String_time_exec(Str_timeAL,1000,"add"));
        System.out.println("Add String to ArrayList 1000000     ----> "+String_time_exec(Str_timeAL,1000000,"add"));
        System.out.println("Add String to LinkedList 1000       ----> "+String_time_exec(Str_timeLL,1000,"add"));
        System.out.println("Add String to LinkedList 1000000    ----> "+String_time_exec(Str_timeLL,1000000,"add"));
        System.out.println("Set String to ArrayList 1000        ----> "+String_time_exec(Str_timeAL,1000,"set"));
        System.out.println("Set String to ArrayList 1000000     ----> "+String_time_exec(Str_timeAL,1000000,"set"));
        System.out.println("Set String to LinkedList 1000       ----> "+String_time_exec(Str_timeLL,1000,"set"));
        System.out.println("Set String to LinkedList 1000000    ----> "+String_time_exec(Str_timeLL,1000000,"set"));
        System.out.println("Get String to ArrayList 1000        ----> "+String_time_exec(Str_timeAL,1000,"get"));
        System.out.println("Get String to ArrayList 1000000     ----> "+String_time_exec(Str_timeAL,1000000,"get"));
        System.out.println("Get String to LinkedList 1000       ----> "+String_time_exec(Str_timeLL,1000,"get"));
        System.out.println("Get String to LinkedList 1000000    ----> "+String_time_exec(Str_timeLL,1000000,"get"));
        System.out.println("Remove String to ArrayList 1000     ----> "+String_time_exec(Str_timeAL,1000,"remove"));
        System.out.println("Remove String to ArrayList 1000000  ----> "+String_time_exec(Str_timeAL,1000000,"remove"));
        System.out.println("Remove String to LinkedList 1000    ----> "+String_time_exec(Str_timeLL,1000,"remove"));
        System.out.println("Remove String to LinkedList 1000000 ----> "+String_time_exec(Str_timeLL,1000000,"remove"));

    }
}
