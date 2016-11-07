package example;

/**
 * Created by Admin on 07.11.2016.
 */
abstract class Bird
{

    abstract void sing();

};
class walking extends Bird
{
    final void sing()
    {
        System.out.println("I am walking");
    }
};
class flying extends Bird
{
    final void sing()
    {
        System.out.println("I am flying");
    }
};
class singing extends Bird
{
    final void sing()
    {
        System.out.println("I am singing");
    }
};
class birds extends Bird
{
    final void sing()
    {
        System.out.println("I am Bird");
    }

};


public class task_3_1 {

    public static void main(String[] args)
    {
        walking pinguine = new walking();
        pinguine.sing();
        flying sparrow = new flying();
        sparrow.sing();
        singing nightingale = new singing();
        nightingale.sing();
        birds chicken = new birds();
        chicken.sing();
    };


};
