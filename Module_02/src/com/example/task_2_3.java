package com.example;

/**
 * Created by Volodymyr Tymchuk
 */
public class task_2_3 {
    public static String transaction(int balance, double withdrawal)
    {
        double tr_money = withdrawal*1.05;
        String res = "";
        if (tr_money>balance) res = "NO";
        else res = withdrawal + " " + (balance-tr_money);
        return res;
    }
    public static void persontransaction(int[] balances,String[] ownerNames,String ownerName, double withdrawal)
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
        System.out.println(ownerName+" "+task_2_3.transaction(balances[tmp_flag],withdrawal));

    }

    public static void main(String[] args) {

        int[] balances = {1200, 250, 2000, 500, 3200};
        String[] ownerNames = {"Jane", "Ann", "Jack", "Oww", "Lane"};

        String ownerName = "Ann";
        double withdrawal = 100;
        task_2_3.persontransaction(balances,ownerNames,ownerName,withdrawal);
    }

}
