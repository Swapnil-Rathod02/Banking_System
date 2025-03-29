package app.user;

import java.time.LocalDate;

public class Customer {
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private int accNo;
    private double balance;
    private String accountType;
    public Customer(int accNo, String firstName, String lastName,LocalDate dob, double balance, String accountType){
        this.accNo=accNo;
        this.firstName=firstName;
        this.lastName=lastName;
        this.balance=balance;
        this.accountType=accountType;
        this.dob=dob;
    }

    public Customer(int accNo){
        this.accNo=accNo;
    }
    public int getAccNo(){
        return accNo;
    }
    public double getBalance(){return balance;}
    public void setBalance(double amount){
        this.balance=amount;
    }

    @Override
    public String toString(){
        return "Account no: "+accNo+" FirstName: "+ firstName+" "+lastName +" AccountType: "+accountType;
    }

    @Override
    public boolean equals(Object c) {
        if (c instanceof Customer) {
            return this.accNo == ((Customer) c).accNo;
        }
        return false;
    }

}
