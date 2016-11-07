package example;

import java.util.Date;

/**
 * Created by Admin on 07.11.2016.
 */
public  class Course
{
    Date startDate;
    String name;
    int hoursDuration;
    String teacherName;
    public Course( Date startDate,String name)
    {
        this.startDate = startDate;
        this.name = name;
    };
    public Course(int hourseDuration, String name, String teacherName)
    {
        this.hoursDuration = hourseDuration;
        this.name = name;
        this.teacherName = teacherName;
    };
};
public class Student
{
    String firstName;
    String lastName;
    int group;
    Course[] coursesTaken;
    int age;

};
public class task_3_3 {
    public static void main(String[] args)
    {
        Adder math_test = new Adder();
        Integer x = new Integer(2);
        Integer y = new Integer(1);
        System.out.println(math_test.add(x,y));
        System.out.println(math_test.check(x,y));
    };
}
