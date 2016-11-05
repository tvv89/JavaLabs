package com.example;

/**
 * Created by Volodymyr Tymchuk
 */
public class task_2_2 {
    public static void transaction(double balance, double withdrawal)
    {
        double tr_money = withdrawal*1.05;
        if (tr_money>balance) System.out.println("NO");
        else System.out.println("OK "+withdrawal*0.05+ " "+(balance-tr_money));
    }

    public static void main(String[] args) {
        double balance = 100;
        double withdrawal = 10;
        task_2_2.transaction(balance,withdrawal);
    }

}
