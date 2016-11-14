package example;

/**
 * Created by Volodymyr Tymchuk
 */
class User
{
    private String name;
    private int balance;
    private int monthsOfEmployment;
    private String companyName;
    private int salary;
    private String currency;

    public User(String name, int balance, int monthsOfEmployment, String companyName, int salary, String currency) {
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.currency = currency;
    }

    public void printUser()
    {
        System.out.println(this.name);
        System.out.println(this.balance);
        System.out.println(this.monthsOfEmployment);
        System.out.println(this.companyName);
        System.out.println(this.salary);
        System.out.println(this.currency);
    }

    void  paySalary()
    {
        this.setBalance(this.getBalance()+this.getSalary());
    };
    void  withdraw(int summ)
    {
        if (summ>=0)
        {
            int diff_balance;
            double k = 1.05;
            if (summ>1000) k = 1.1;
            diff_balance =  (int)(this.balance-summ*k);
            if (diff_balance>0)
            {
                this.balance = diff_balance;
            }
        }
    }
    int companyNameLenght()
    {
        return  this.companyName.length();
    }
    void monthIncreaser(int addMonth)
    {
        this.monthsOfEmployment += addMonth;
    }

    //getters & setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getMonthsOfEmployment() {
        return monthsOfEmployment;
    }
    public void setMonthsOfEmployment(int monthsOfEmployment) {
        this.monthsOfEmployment = monthsOfEmployment;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
public class task_3_4 {
     public static void main(String[] args)
     {
         User usr = new User("User1", 10000, 10,"Company1",5000,"EURO");
         usr.printUser();
         usr.paySalary();
         usr.withdraw(1001);
         usr.monthIncreaser(5);
         System.out.println();
         usr.printUser();

     }

}
