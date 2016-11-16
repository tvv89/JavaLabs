package four.example;

/**
 * Created by Volodymyr Tymchuk on 15.11.2016 for JavaLabs.
 */


/**********************
 ******* task #2 ******
 **********************/
enum Currencys {USD, EUR};

/**********************
 ******* task #1 ******
 **********************/
abstract class Bank
{

    long id;
    String bankCountry;
    Currencys currency;
    int numberOfEmployees;
    double avrSalaryOfEmployee;
    long rating;
    long totalCapital;

    abstract int getLimitOfWithdrawal();
    abstract int getLimitOfFunding();
    abstract int getMonthlyRate();
    abstract int getCommission(int summ);
    double moneyPaidMonthlyForSalary()
    {
        return 1;
    };

    public Bank(long id, String bankCountry, Currencys currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        this.id = id;
        this.bankCountry = bankCountry;
        this.currency = currency;
        this.numberOfEmployees = numberOfEmployees;
        this.avrSalaryOfEmployee = avrSalaryOfEmployee;
        this.rating = rating;
        this.totalCapital = totalCapital;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public Currencys getCurrency() {
        return currency;
    }

    public void setCurrency(Currencys currency) {
        this.currency = currency;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getAvrSalaryOfEmployee() {
        return avrSalaryOfEmployee;
    }

    public void setAvrSalaryOfEmployee(double avrSalaryOfEmployee) {
        this.avrSalaryOfEmployee = avrSalaryOfEmployee;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public long getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(long totalCapital) {
        this.totalCapital = totalCapital;
    }
}

/**********************
 ******* task #3 ******
 **********************/

class USBank extends Bank
{
    public USBank(long id, String bankCountry, Currencys currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    public int getLimitOfWithdrawal()
    {
        int limit = 0;
        if (this.getCurrency() == Currencys.USD) limit = 1000;
        if (this.getCurrency() == Currencys.EUR) limit = 1200;
        return limit;
    }
    public int getLimitOfFunding()
    {
        int limit = 0;
        if (this.getCurrency() == Currencys.EUR) limit = 10000;
        return limit;
    }
    public int getMonthlyRate()
    {
        int rate = 0;
        if (this.currency == Currencys.USD) rate = 1;
        if (this.currency == Currencys.EUR) rate =2;
        return rate;
    }
    public int getCommission(int summ)
    {
        int commission = 0;
        if (this.currency == Currencys.USD)
        {
            if (summ < 1000) commission = 5;
            else commission = 7;
        }
        if (this.currency == Currencys.EUR)
        {
            if (summ < 1000) commission = 6;
            else commission = 8;
        }
        return commission;

    }

}

class EUBank extends Bank
{
    public EUBank(long id, String bankCountry, Currencys currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    public int getLimitOfWithdrawal()
    {
        int limit = 0;
        if (this.getCurrency() == Currencys.USD) limit = 2000;
        if (this.getCurrency() == Currencys.EUR) limit = 2200;
        return limit;
    }
    public int getLimitOfFunding()
    {
        int limit = 0;
        if (this.getCurrency() == Currencys.EUR) limit = 20000;
        if (this.getCurrency() == Currencys.USD) limit = 10000;
        return limit;
    }
    public int getMonthlyRate()
    {
        int rate = 0;
        if (this.currency == Currencys.EUR) rate = 1;
        return  rate;
    }
    public int getCommission(int summ)
    {
        int commission = 0;
        if (this.currency == Currencys.USD)
        {
            if (summ < 1000) commission = 5;
            else commission = 7;
        }
        if (this.currency == Currencys.EUR)
        {
            if (summ < 1000) commission = 2;
            else commission = 4;
        }
        return commission;

    }

}

class ChinaBank extends Bank
{
    public ChinaBank(long id, String bankCountry, Currencys currency, int numberOfEmployees, double avrSalaryOfEmployee, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployees, avrSalaryOfEmployee, rating, totalCapital);
    }

    public int getLimitOfWithdrawal()
    {
        int limit = 0;
        if (this.getCurrency() == Currencys.USD) limit = 100;
        if (this.getCurrency() == Currencys.EUR) limit = 150;
        return limit;
    }
    public int getLimitOfFunding()
    {
        int limit = 0;
        if (this.getCurrency() == Currencys.EUR) limit = 5000;
        if (this.getCurrency() == Currencys.USD) limit = 10000;
        return limit;
    }
    public int getMonthlyRate()
    {
        int rate = 0;
        if (this.currency == Currencys.USD) rate = 1;
        return  rate;
    }
    public int getCommission(int summ)
    {
        int commission = 0;
        if (this.currency == Currencys.USD)
        {
            if (summ < 1000) commission = 3;
            else commission = 5;
        }
        if (this.currency == Currencys.EUR)
        {
            if (summ < 1000) commission = 10;
            else commission = 11;
        }
        return commission;

    }

}

/*********************
******* task #4 ******
**********************/

class User
{
    long id;
    String name;
    double balance;
    int monthsOfEmployment;
    String companyName;
    int salary;
    Bank bank;

    public User(long id, String name, double balance, int monthsOfEmployment, String companyName, int salary, Bank bank) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.monthsOfEmployment = monthsOfEmployment;
        this.companyName = companyName;
        this.salary = salary;
        this.bank = bank;
    }

    @Override
    public String toString()
    {
        return this.name+" works in "+this.companyName;
    }
    void withdrawOfUser(User user,int amount)
    {

    }
}

/*********************
 ******* task #5 ******
 **********************/
interface BankSystem
{
    void withdrawOfUser(User user, int amount);
    void fundUser(User user, int amount);
    void transferMoney(User fromUser, User toUser, int amount);
    void paySalary(User user);
}

class BankSystemImpl implements BankSystem
{
    public void withdrawOfUser(User user, int amount) {
        if ((amount<user.bank.getLimitOfWithdrawal() || user.bank.getLimitOfWithdrawal()==0) && amount>0)
        user.balance -= amount*(1+0.01*user.bank.getCommission(amount));
    }

    public void fundUser(User user, int amount) {
        if ((amount<user.bank.getLimitOfFunding() || user.bank.getLimitOfWithdrawal()==0) && amount>0)
            user.balance += amount;
    }

    public void transferMoney(User fromUser, User toUser, int amount) {
        //math operation
        double bal_fromUser = fromUser.balance - amount*(1+0.01*fromUser.bank.getCommission(amount));
        if (bal_fromUser>0 && fromUser.bank.getLimitOfWithdrawal()>amount && (toUser.bank.getLimitOfFunding()>amount || toUser.bank.getLimitOfFunding()==0))
        {
            withdrawOfUser(fromUser,amount);
            fundUser(toUser,amount);
        }
    }

    public void paySalary(User user) {
        user.balance +=user.salary;
    }
}

public class task_4 {
    public static void main (String[] args)
    {
        // Create 6 banks
        USBank AmeriCan = new USBank(123456789,"USA",Currencys.USD,55,123,98,1000000000);
        USBank LondonCan = new USBank(123456780,"England",Currencys.EUR,88,15.6,99,2000000000);

        EUBank DeucheBank = new EUBank(987654321,"Germany",Currencys.EUR,32,12,98,1800000000);
        EUBank OshadBank = new EUBank(777777777,"Ukraine",Currencys.USD,237,25,48,50000000);

        ChinaBank KomunaBank = new ChinaBank(123456789,"China",Currencys.USD,1200,123,97,2000000000);
        ChinaBank GBBank = new ChinaBank(123456780,"Singapour",Currencys.EUR,875,123,95,2000000000);

        // Create 6 different users
        User usr1 = new User(11111111,"John Smit",1000,15,"IT.devel.cech",2500,AmeriCan);
        User usr2 = new User(22222222,"Mr. Been",350,14,"GolbalLogic",3800,LondonCan);
        User usr3 = new User(33333333,"Gans Schmidt",1000,13,"Epam",2700,DeucheBank);
        User usr4 = new User(44444444,"Ivanov Ivan",80,12,"SoftDev",400,OshadBank);
        User usr5 = new User(55555555,"Li Si Cin",700,11,"ChinaSoft",1200,KomunaBank);
        User usr6 = new User(66666666,"Hu win Chan",800,10,"IT.hueWay",1300,GBBank);

        //use 4 different methods for all users
        BankSystemImpl bankomat_operation = new BankSystemImpl();

        // for User #1
        System.out.println(usr1.toString());
        System.out.print(usr1.balance+" ");
        bankomat_operation.withdrawOfUser(usr1,100);
        System.out.print(usr1.balance+" ");
        bankomat_operation.fundUser(usr1,100);
        System.out.print(usr1.balance+" ");
        bankomat_operation.transferMoney(usr1,usr2,100);
        System.out.print(usr1.balance+" ");
        bankomat_operation.paySalary(usr1);
        System.out.println(usr1.balance);

        // for User #2
        System.out.println(usr2.toString());
        System.out.print(usr2.balance+" ");
        bankomat_operation.withdrawOfUser(usr2,100);
        System.out.print(usr2.balance+" ");
        bankomat_operation.fundUser(usr2,100);
        System.out.print(usr2.balance+" ");
        bankomat_operation.transferMoney(usr2,usr3,100);
        System.out.print(usr2.balance+" ");
        bankomat_operation.paySalary(usr2);
        System.out.println(usr2.balance);

        // for User #3
        System.out.println(usr3.toString());
        System.out.print(usr3.balance+" ");
        bankomat_operation.withdrawOfUser(usr3,100);
        System.out.print(usr3.balance+" ");
        bankomat_operation.fundUser(usr3,100);
        System.out.print(usr3.balance+" ");
        bankomat_operation.transferMoney(usr3,usr4,100);
        System.out.print(usr3.balance+" ");
        bankomat_operation.paySalary(usr3);
        System.out.println(usr3.balance);

        // for User #4
        System.out.println(usr4.toString());
        System.out.print(usr4.balance+" ");
        bankomat_operation.withdrawOfUser(usr4,100);
        System.out.print(usr4.balance+" ");
        bankomat_operation.fundUser(usr4,100);
        System.out.print(usr4.balance+" ");
        bankomat_operation.transferMoney(usr4,usr5,100);
        System.out.print(usr4.balance+" ");
        bankomat_operation.paySalary(usr4);
        System.out.println(usr4.balance);

        // for User #5
        System.out.println(usr5.toString());
        System.out.print(usr5.balance+" ");
        bankomat_operation.withdrawOfUser(usr5,100);
        System.out.print(usr5.balance+" ");
        bankomat_operation.fundUser(usr5,100);
        System.out.print(usr5.balance+" ");
        bankomat_operation.transferMoney(usr5,usr6,100);
        System.out.print(usr5.balance+" ");
        bankomat_operation.paySalary(usr6);
        System.out.println(usr5.balance);

        // for User #6
        System.out.println(usr6.toString());
        System.out.print(usr6.balance+" ");
        bankomat_operation.withdrawOfUser(usr6,100);
        System.out.print(usr6.balance+" ");
        bankomat_operation.fundUser(usr6,100);
        System.out.print(usr6.balance+" ");
        bankomat_operation.transferMoney(usr6,usr1,100);
        System.out.print(usr6.balance+" ");
        bankomat_operation.paySalary(usr6);
        System.out.println(usr6.balance);




    }
}
