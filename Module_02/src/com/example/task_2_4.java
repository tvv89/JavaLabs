package com.example;

/**
 * Created by Volodymyr Tymchuk
 */
public class task_2_4 {

    public static void addbalance(int[] balances,String[] ownerNames,String ownerName, double withdrawal)
    {
        int tmp_flag=0;
        for (int i=0; i<ownerNames.length;i++)
        {
            if (ownerNames[i]==ownerName)
            {
                tmp_flag = i;
                break;
            }
        }
        System.out.println(ownerName+" "+(balances[tmp_flag]+withdrawal));

    }

    public static void main(String[] args) {

        int[] balances = {1200, 250, 2000, 500, 3200};
        String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

        String ownerName = "Oww";
        double withdrawal = 100;
        task_2_4.addbalance(balances,ownerNames,ownerName,withdrawal);
    }

}
