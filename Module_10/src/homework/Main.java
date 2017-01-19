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
            System.out.println("Executed!");
        }
    }
}
