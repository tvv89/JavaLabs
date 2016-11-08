package example;

import java.util.Date;

/**
 * Created by Admin on 07.11.2016.
 */
class Course
{
    private Date startDate;
    private String name;
    private int hoursDuration;
    private String teacherName;
    public Course(){};
    public Course( Date startDate,String name)
    {
        this.setStartDate(startDate);
        this.setName(name);
    };
    public Course(int hourseDuration, String name, String teacherName)
    {
        this.setHoursDuration(hourseDuration);
        this.setName(name);
        this.setTeacherName(teacherName);
    };


    /*getters & setters*/
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHoursDuration(int hoursDuration) {
        this.hoursDuration = hoursDuration;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getName() {
        return name;
    }

    public int getHoursDuration() {
        return hoursDuration;
    }

    public String getTeacherName() {
        return teacherName;
    }
};
class Student
{
    private String firstName;
    private String lastName;
    private int group;
    private Course[] coursesTaken;
    private int age;

    public Student() {};
    public Student(String firstName, String lastName, int group)
    {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGroup(group);
    };
    public Student(String lastName, Course[] coursesTaken)
    {
        this.setLastName(lastName);
        this.setCoursesTaken(coursesTaken);

    };

    /*getters & setters*/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setCoursesTaken(Course[] coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGroup() {
        return group;
    }

    public Course[] getCoursesTaken() {
        return coursesTaken;
    }

    public int getAge() {
        return age;
    }
};
class CollegeStudent extends Student
{
    private String collegeName = "";
    private int rating = 0;
    private long id = 0;
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
        this.setCoursesTaken(coursesTaken);
        this.setAge(age);
        this.setCollegeName(collegeName);
        this.setRating(rating);
        this.setId(id);

    };

    /*getters & setters*/
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public int getRating() {
        return rating;
    }

    public long getId() {
        return id;
    }
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
        this.setSecretKey(secretKey);
    };


    /*getters & setters*/
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
