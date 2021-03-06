package com.example;

import java.util.Arrays;


/**
 * Created by Volodymyr Tymchuk
 */

public class task_2_1 {

    public int sum(int[] array)
    {
        int summ = 0;
        for (int i : array) {summ += i;}
        return summ;
    }
    public double sum(double[] array)
    {
        double summ = 0;
        for (double i : array) {summ +=  i;}
        return summ;
    }
    public int min(int[] array)
    {
        int res = array[0];
        for (int i : array) {if (i<res) res=i;}
        return res;
    }
    public double min(double[] array)
    {
        double res = array[0];
        for (double i : array) {if (i<res) res=i;}
        return res;
    }
    public int max(int[] array)
    {
        int res = array[0];
        for (int i : array) {if (i>res) res=i;}
        return res;
    }
    public double max(double[] array)
    {
        double res = array[0];
        for (double i : array) {if (i>res) res=i;}
        return res;
    }
    public int maxPositive(int[] array)
    {
        int res = 0;
        if (max(array)>0) res = max(array);
        return res;
    }
    public double maxPositive(double[] array)
    {
        //Objects res = 0;

        double res = 0;
        if (max(array)>0) res = max(array);
        return res;
    }
    public int multiplication(int[] array)
    {
        int res = 1;
        for (int i : array) {res *= i;}

        return res;
    }
    public double multiplication(double[] array)
    {
        double res = 1;
        for (double i : array) {res *= i;}
        return res;
    }
    public int modulus(int[] array)
    {
        return array[0] % array[array.length-1];
    }
    public double modulus(double[] array)
    {
        return array[0] % array[array.length-1];

    }

    public int secondLargest(int[] array)
    {
        Arrays.sort(array);
        return array[array.length-2];
    }
    public double secondLargest(double[] array)
    {
        Arrays.sort(array);
        return array[array.length-2];
    }


    public static void main(String[] args) {
        int[] int_arr = {13,2,3,4,55,6,7,8,9,10};
        double[] double_arr = {1.1,2.1,3.1,4.1,5.1,6.1,7.1,8.1,9.1,10.1};
        //System.out.println);
        task_2_1 ex = new task_2_1();

        System.out.println("Sum int: "+ ex.sum(int_arr));
        System.out.println("Sum double: "+ex.sum(double_arr));
        System.out.println("Min int: "+ex.min(int_arr));
        System.out.println("Min double: "+ex.min(double_arr));
        System.out.println("Max int: "+ex.max(int_arr));
        System.out.println("Max double: "+ex.max(double_arr));
        System.out.println("Max Positive int: "+ex.maxPositive(int_arr));
        System.out.println("Max Positive double: "+ex.maxPositive(double_arr));
        System.out.println("Multiplication int: "+ex.multiplication(int_arr));
        System.out.println("Multiplication double: "+ex.multiplication(double_arr));
        System.out.println("Modulus int: "+ex.modulus(int_arr));
        System.out.println("Modulus double: "+ex.modulus(double_arr));
        System.out.println("secondLargest int: "+ex.secondLargest(int_arr));
        System.out.println("secondLargest double: "+ex.secondLargest(double_arr));

    }


};



