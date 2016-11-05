package com.example;

/**
 * Created by Volodymyr Tymchuk
 */

public class task_2_1 {

    public int sum(int[] array)
    {
        int summ = 0;
        for (int i = 0; i <array.length; ++i) {
            summ += array[i];
            }

        return summ;
    }
    public double sum(double[] array)
    {
        double summ = 0;
        for (int i = 0; i <array.length; ++i) {
            summ +=  array[i];
        }

        return summ;
    }
    public int min(int[] array)
    {
        int res = array[0];
        for (int i = 1; i <array.length; ++i)
        {
            if (array[i]<res) res=array[i];
        }

        return res;
    }
    public double min(double[] array)
    {
        double res = array[0];
        for (int i = 1; i <array.length; ++i)
        {
            if (array[i]<res) res=array[i];
        }

        return res;
    }
    public int max(int[] array)
    {
        int res = array[0];
        for (int i = 1; i <array.length; ++i)
        {
            if (array[i]>res) res=array[i];
        }

        return res;
    }
    public double max(double[] array)
    {
        double res = array[0];
        for (int i = 1; i <array.length; ++i)
        {
            if (array[i]>res) res=array[i];
        }

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
        double res = 0;
        if (max(array)>0) res = max(array);
        return res;
    }
    public int multiplication(int[] array)
    {
        int res = 1;
        for (int i = 0; i <array.length; ++i) {
            res = res*array[i];
        }

        return res;
    }
    public double multiplication(double[] array)
    {
        double res = 1;
        for (int i = 0; i <array.length; ++i) {
            res = res*array[i];
        }

        return res;
    }
    public void modulus(int[] array)
    {
        int f_el = Math.abs(array[0]);
        int l_el = Math.abs(array[array.length-1]);
        System.out.println("Modulus first element: "+f_el+" and last: "+l_el);
    }
    public void modulus(double[] array)
    {
        double f_el = Math.abs(array[0]);
        double l_el = Math.abs(array[array.length-1]);
        System.out.println("Modulus first element: "+f_el+" and last: "+l_el);
    }
    public void sort(int[] array)
    {
        for(int j=array.length-1;j>=0;j--)
            for (int i=0; i<j;i++)
            {
                if (array[i]>array[i+1])
                {
                    int buff = array[i+1];
                    array[i+1]=array[i];
                    array[i]=buff;
                }
            }

    }
    public void sort(double[] array)
    {
        for(int j=array.length-1;j>=0;j--)
            for (int i=0; i<j;i++)
            {
                if (array[i]>array[i+1])
                {
                    double buff = array[i+1];
                    array[i+1]=array[i];
                    array[i]=buff;
                }
            }

    }
    public int secondLargest(int[] array)
    {
        sort(array);
        return array[array.length-2];
    }
    public double secondLargest(double[] array)
    {
        sort(array);
        return array[array.length-2];
    }
    public static void main(String[] args) {
        int[] int_arr = {100,2,3,4,55,6,7,8,9,1};
        double[] double_arr = {1.1,2.1,3.1,4.1,5.1,6.1,7.1,8.1,9.1,10.1};
        task_2_1 ex = new task_2_1();
        System.out.println("Sum int: "+ex.sum(int_arr));
        System.out.println("Sum double: "+ex.sum(double_arr));
        System.out.println("Min int: "+ex.min(int_arr));
        System.out.println("Min double: "+ex.min(double_arr));
        System.out.println("Max int: "+ex.max(int_arr));
        System.out.println("Max double: "+ex.max(double_arr));
        System.out.println("Max Positive int: "+ex.maxPositive(int_arr));
        System.out.println("Max Positive double: "+ex.maxPositive(double_arr));
        System.out.println("Multiplication int: "+ex.multiplication(int_arr));
        System.out.println("Multiplication double: "+ex.multiplication(double_arr));
        ex.modulus(int_arr);
        ex.modulus(double_arr);
        System.out.println("secondLargest int: "+ex.secondLargest(int_arr));
        System.out.println("secondLargest double: "+ex.secondLargest(double_arr));

    }


};



