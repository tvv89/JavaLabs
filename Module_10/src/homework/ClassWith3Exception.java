package homework;

/**
 * Created by Volodymyr Tymchuk on 19.01.2017 for JavaLabs.
 */
public class ClassWith3Exception {
    public String getTestException(String i) throws MyOwnException, ExceptionForF, VirtualException
    {
        if (i.contains("1")) throw new MyOwnException("Exception form MyOwnException");
        if (i.contains("2")) throw new ExceptionForF("Exception form ExceptionForF");
        if (i.contains("3")) throw new VirtualException("Exception form VirtualException");
        return "Executed without exceptions!";
    }
}
