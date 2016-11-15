package four.example;

/**
 * Created by Volodymyr Tymchuk on 15.11.2016 for JavaLabs.
 */
enum Currencys {USD, EUR};

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
public class task_4 {
    public static void main (String[] args)
    {
        System.out.println("Hello!!");
    }
}
