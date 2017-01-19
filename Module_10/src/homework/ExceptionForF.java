package homework;

/**
 * Created by Volodymyr Tymchuk on 19.01.2017 for JavaLabs.
 */
public class ExceptionForF extends Exception {
    private String ExMsg;
    public ExceptionForF(String message) {
        super(message);
        ExMsg = message;
    }
    public String getTextMsg()
    {
        return "My new exception for ClassWithException and "+ ExMsg;
    }

}
