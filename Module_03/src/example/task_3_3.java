package example;

import java.util.Date;

/**
 * Created by Admin on 07.11.2016.
 */
class Course
{
    Date startDate;
    String name;
    int hoursDuration;
    String teacherName;
    public Course(){};
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
class Student
{
    String firstName;
    String lastName;
    int group;
    Course[] coursesTaken;
    int age;

    public Student() {};
    public Student(String firstName, String lastName, int group)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    };
    public Student(String lastName, Course[] coursesTaken)
    {
        this.lastName = lastName;
        this.coursesTaken = coursesTaken;

    };
};
class CollegeStudent extends Student
{
    String collegeName = "";
    int rating = 0;
    long id = 0;
    public CollegeStudent() {super();}
    public CollegeStudent(String firstName, String lastName, int group)
    {
       super(firstName, lastName,group);
    }

    public CollegeStudent(String lastName, Course[] coursesTaken)
    {
        super(lastName, coursesTaken);
    };
    public CollegeStudent(String firstName, String lastName, int group,
                          Course[] coursesTaken, int age, String collegeName, int rating, long id)
    {
        super (firstName, lastName,group);
        int c_count  = coursesTaken.length;
        this.coursesTaken = coursesTaken;
        this.age = age;
        this.collegeName = collegeName;
        this.rating = rating;
        this.id = id;

    };
};
class SpecialStudent extends CollegeStudent
{
    private long secretKey;
    private String email;
    public SpecialStudent(String firstName, String lastName, int group)
    {
        super(firstName, lastName,group);
    };
    public SpecialStudent(String firstName, String lastName, int group,
                          Course[] coursesTaken, int age, String collegeName, int rating, long id)
    {
        super(firstName, lastName, group, coursesTaken, age, collegeName, rating, id);
    };
    public SpecialStudent(long secretKey)
    {
       super();
        this.secretKey = secretKey;
    };

    public long getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(long secretKey) {
        this.secretKey = secretKey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
};


public class task_3_3 {
    public static void main(String[] args)
    {
        Course[] courses_all = new Course[5];
        for (int i = 0; i<5; i++)
        {
            String nameC = "Course_"+i;
            Date dateC = new Date();
            courses_all[i] = new Course(dateC,nameC);

        }
        Student st1 = new Student("first Name 1","last Name 1", 1);
        Student st2 = new Student("first Name 2",courses_all);
        CollegeStudent st3 = new CollegeStudent("first Name 3", "last Name 3", 3);
        CollegeStudent st4 = new CollegeStudent("first Name 4", courses_all);
        CollegeStudent st5 = new CollegeStudent("first Name 5", "last Name 5",5,courses_all,18,"college 5",5,55555);
        SpecialStudent st6 = new SpecialStudent("first Name 6", "last Name 6", 6);
        SpecialStudent st7 = new SpecialStudent("first Name 7", "last Name 7",7,courses_all,21,"college 7",7,77777);
        SpecialStudent st8 = new SpecialStudent(7654321);


        System.out.println("Go");
        System.out.println("IT");
    };
}
