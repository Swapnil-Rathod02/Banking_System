package app.utils;

import app.bankExecption.CustomException;
import app.user.Customer;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;


public class Validation {
    public static LocalDate getAge(String dob) throws CustomException{
        LocalDate date=LocalDate.parse(dob);
        int age= Period.between(date,LocalDate.now()).getYears();
        if(age<18){
            throw new CustomException("user under age");
        }
        return date;
    }
    public static double checkBalance(double balance)throws CustomException {
        if(balance<5000){
            throw new CustomException("insufficient balance");
        }
        return balance;
    }
   public static double sufficientBalance(Customer c,double balance)throws CustomException {
       if (c.getBalance() < balance)
           throw new CustomException("Insufficient fund");
       return c.getBalance();
   }
   public static Customer isUserExist(Customer customer)throws  CustomException{
        if(customer==null)throw new CustomException("User doesent exits");
        return customer;
   }
}
