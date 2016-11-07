package example;

/**
 * Created by Admin on 07.11.2016.
 */

class Arithmetic
{
    public int add(int a,int b)
    {
        int res;
        res = a+b;
        return res;
    }
};
class Adder extends Arithmetic
{
    boolean check(int a, int b)
    {
        if (a>=b) return true;
        else return false;
    }
};
public class task_3_2 {
    public static void main(String[] args)
    {

    };
}
