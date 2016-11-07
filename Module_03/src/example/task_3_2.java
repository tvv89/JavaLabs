package example;

/**
 * Created by Admin on 07.11.2016.
 */

class Arithmetic
{
    public int add(Integer a,Integer b)
    {
        int res;
        res = a.intValue()+b.intValue();
        return res;
    }
};
class Adder extends Arithmetic
{
    boolean check(Integer a, Integer b)
    {
        if (a.intValue()>=b.intValue()) return true;
        else return false;
    }
};
public class task_3_2 {
    public static void main(String[] args)
    {
        Adder math_test = new Adder();
        Integer x = new Integer(2);
        Integer y = new Integer(1);
        System.out.println(math_test.add(x,y));
        System.out.println(math_test.check(x,y));
    };
}
