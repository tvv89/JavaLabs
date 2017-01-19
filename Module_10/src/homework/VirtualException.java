package homework;

/**
 * Created by Volodymyr Tymchuk on 19.01.2017 for JavaLabs.
 */
public class VirtualException extends Exception {
    private String ExMsg;
    public VirtualException(String message) {
        super(message);
        this.ExMsg = message;
    }
    public String getTextMsg()
    {
        return "This is ne exception for Task#5 from " + this.getClass().toString();
    }
}
