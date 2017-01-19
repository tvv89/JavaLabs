package homework;

/**
 * Created by Volodymyr Tymchuk on 19.01.2017 for JavaLabs.
 */
public class MyOwnException extends Exception {
    private String ExMsg;

    public MyOwnException(String message) {
        super(message);
        this.ExMsg = message;
    }

    public void ShowMsg ()
    {
        System.out.println(ExMsg);
    }

    public String getExMsg() {
        return ExMsg;
    }

}
