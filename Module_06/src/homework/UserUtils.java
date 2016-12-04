package homework;

/**
 * Created by Volodymyr Tymchuk on 04.12.2016 for JavaLabs.
 */
public class UserUtils {
    public static User[] uniqueUsers(User[] users)
    {
        //создаем временный масив уникальных элементов, длина которого не больше
        //чем входящего массива
        User[] tmp = new User[users.length];
        int count = 1;
        //изначально первый элемент всегда уникален
        tmp[0] = users[0];
        //проверяем все элементы на уникальность
        for (User i: users)
        {
            //переменная отвечающая за уникальность
            boolean flag=false;
            //проверяем текущий элемент на присутствие в массиве уникальных элементов
            for (int j = 0; j<count; j++) {
                //проверяем равны ли элементы
                flag  = i.equals(tmp[j]);
                //если совпадение было, выходим из цикла
                if (flag) break;
            }
            if (!flag)
            {
                //если небыло совпадения - записываем
                // элемент в массив уникальных
                tmp[count] = i;
                count++;
            }
        }
        //возвращаем результат
        return reArray(tmp, count);
    }
    public static User[] usersWithContitionalBalance(User[] users, int balance)
    {
        //создаем временный масив элементов с нужным балансом,
        // длина которого не больше чем входящего массива
        User[] tmp = new User[users.length];
        int count = 0;
        //проверяем все элементы на совпадение баланса
        for (User i: users)
        {
            if (i.getBalance()==balance)
            {
                //если выполняется условие - записываем
                // элемент в массив найденых
                tmp[count] = i;
                count++;
            }

        }
        //возвращаем результат
        return reArray(tmp,count);
    }
    public static final User[] paySalaryToUsers(User[] users)
    {
        for (User i:users)
        {
          i.setBalance(i.getBalance()+i.getSalary());
        }
        return users;
    }
    public static final long[] getUsersId(User[] users)
    {
        long[] resId = new long[users.length];
        for (int i=0; i<users.length; i++)
        {
            resId[i] = users[i].getId();
        }
        return resId;
    }
    public static User[] deleteEmptyUsers(User[] users)
    {
        int count = 0;
        User[] tmp = new User[users.length];
        for (User i: users)
        {
            //детекция пустого User:
            //поскольку в задании не указано как это детектировать
            //предположил, что если Id>0 и FirstName не пустое -
            //то такой пользователь точно не пустой и попадает в массив
            if (i.getId()>0&&i.getFirstName().length()>1)
            {
                tmp[count] = i;
                count++;
            }
        }
        return reArray(tmp,count);
    }

    //это чисто системное решение (не для ДЗ), чтоб соблюсти DRY
    //для того чтоб отсечь все элементы не NULL из массива
    //и укоротить длину массива до нужной чтоб было удобно работать
    //далее в JavaCore мы выучим коллекции и отойдем от этой не нужной операции)))
    private static User[] reArray(User[] users, int count)
    {
        User[] res = new User[count];
        for (int i = 0; i <count ; i++) {
            res[i] = users[i];
        }
        //возвращаем результат
        return res;
    }

    //только для удобства (в ДЗ такого нету)
    //чтоб вывести массив на экран
    public static void printArray(User[] users)
    {
        for (User i: users) {
            System.out.println(i.toString());
        }
    }
}
