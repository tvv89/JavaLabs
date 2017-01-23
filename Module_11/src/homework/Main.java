package homework;

/**
 * Created by Volodymyr Tymchuk on 22.01.2017 for JavaLabs.
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("hello");
        try {
            Thread.sleep(1000); // Just to give the user a chance to see "hello".
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\b\b\b\b\b");
        System.out.print("world");

    }
}
