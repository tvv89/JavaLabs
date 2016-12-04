package homework;

import java.util.Arrays;

/**
 * Created by Volodymyr Tymchuk on 04.12.2016 for JavaLabs.
 */
public final class ArraysUtils {

    public static int sum(int[] array)
    {
        int summ = 0;
        for (int i : array) {summ += i;}
        return summ;
    }

    public static int min(int[] array)
    {
        int res = array[0];
        for (int i : array) {if (i<res) res=i;}
        return res;
    }

    public static int max(int[] array)
    {
        int res = array[0];
        for (int i : array) {if (i>res) res=i;}
        return res;
    }

    public static int maxPositive(int[] array)
    {
        int res = 0;
        if (max(array)>0) res = max(array);
        return res;
    }

    public static int multiplication(int[] array)
    {
        int res = 1;
        for (int i : array) {res *= i;}
        return res;
    }

    public static int modulus(int[] array)
    {
        return array[0] % array[array.length - 1];
    }

    public static int secondLargest(int[] array)
    {
        Arrays.sort(array);
        return array[array.length-2];
    }

    public static int[] reverse(int[] array)
    {
        for (int i=0;  i<(int)(array.length/2); i++)
        {
            int tmp = array[i];
            array[i] = array[array.length-1 - i];
            array[array.length-1-i] = tmp;
        }
        return array;

    }
    public static int[] findEvenElements(int[] array)
    {
        int[] tmp = new int[array.length];
        int count = 0;
        for (int i:array)
        {
            if (i%2==0)
            {
                tmp[count]=i;
                count++;
            }
        }
        int[] res = new int[count];
        for (int i = 0; i <count ; i++) {
            res[i] = tmp[i];
        }
        return res;
    }


}
