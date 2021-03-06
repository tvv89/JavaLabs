package homework;


/**
 * Created by Volodymyr Tymchuk on 19.01.2017 for JavaLabs.
 */
public class Main {
    public static void main(String[] args) {
        try {
            throw new Exception("Some text for Task#1");
        }
        catch (Exception e)
        {
            System.out.println("Print test: "+e.getMessage());
        }
        finally {
            System.out.println("Executed task#1!");
        }

        /*
        ---------------------
        ****** Task #2******
        ---------------------
         */
        try {
            throw new MyOwnException("Task #2 complete");
        }
        catch (MyOwnException e)
        {
            e.ShowMsg();
        }
        finally {
            System.out.println("Executed task#2!");
        }
        /*
        ---------------------
        ****** Task #3******
        ---------------------
         */
        Boolean test_task3 = null;
        try {
            System.out.println(test_task3.toString());
        }
        catch (NullPointerException e)
        {
            System.out.println("This value is NULL");
        }
        catch (Exception e)
        {
            System.out.println("Some Exception");
        }
        finally {
            System.out.println("Executed task#3!");
        }
        /*
        ---------------------
        ****** Task #4******
        ---------------------
         */
        ClassWithException newRef = new ClassWithException();
        try {

            newRef.f();
        }
        catch (ExceptionForF eff)
        {
            System.out.println(eff.getTextMsg());
        }
        finally {
            System.out.println("Executed task#4!");
        }
        /*
        ---------------------
        ****** Task #5******
        ---------------------
         */
        ClassWith3Exception task5 = new ClassWith3Exception();
        try {
            task5.getTestException("1");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " "+ e.getClass());
        }
        try {
            task5.getTestException("2");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " "+ e.getClass());
        }
        try {
            task5.getTestException("3");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage() + " "+ e.getClass());
        }

    }
}
