package homework;

/**
 * Created by Volodymyr Tymchuk on 19.01.2017 for JavaLabs.
 */
public class ClassWithException  {
    public void f() throws ExceptionForF
    {
        try {
            g();
        }
        catch (MyOwnException e)
        {
            throw new ExceptionForF(e.getMessage());
        }
    }
    private void g() throws MyOwnException
    {
        throw new MyOwnException("My exception from g();");
    }
}
