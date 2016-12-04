package homework;

/**
 * Created by Volodymyr Tymchuk on 04.12.2016 for JavaLabs.
 */
public class Main {
    public static void main(String[] args) {
        int[] ARR1 = {1,2,3,4,5,6,7,8,9};
        int[] ARR2 = {1,2,3,4,5,6,7,8,9};

        System.out.println(ArraysUtils.sum(ARR1));
        System.out.println(ArraysUtils.min(ARR1));
        System.out.println(ArraysUtils.max(ARR1));
        System.out.println(ArraysUtils.maxPositive(ARR1));
        System.out.println(ArraysUtils.multiplication(ARR1));
        System.out.println(ArraysUtils.modulus(ARR1));
        System.out.println(ArraysUtils.secondLargest(ARR1));

        for (int i: ArraysUtils.reverse(ARR2))
        {
            System.out.print(i+" ");
        }
        System.out.println();

        for (int i: ArraysUtils.findEvenElements(ARR2))
        {
            System.out.print(i+" ");
        }
        System.out.println();


        User[] users = new User[10];
        for (int i = 0; i <users.length ; i++) {
            users[i] = new User(i+11111111,"User_first_"+i, "User_last_"+i,1000+i*50,5000+i*10);
        }

        //UserUtils.printArray(users);
        System.out.println("---------- uniqueUsers----------");
        UserUtils.printArray(UserUtils.uniqueUsers(users));

        System.out.println("---------- usersWithContitionalBalance ----------");
        UserUtils.printArray(UserUtils.usersWithContitionalBalance(users,5050));

        System.out.println("---------- paySalaryToUsers ----------");
        UserUtils.printArray(UserUtils.paySalaryToUsers(users));

        System.out.println("---------- getUsersId ----------");
        long[] idOfUsers;
        idOfUsers = UserUtils.getUsersId(users);
        for (long i: idOfUsers) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("---------- deleteEmptyUsers ----------");
        UserUtils.printArray(UserUtils.deleteEmptyUsers(users));

    }


}
