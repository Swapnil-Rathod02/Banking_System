package app.service;


import app.bankExecption.CustomException;
import app.user.Customer;
import static  app.utils.Validation.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class BankImplementation  implements BankOperation {
        ArrayList<Customer>customers;
        private int cnt;
       public BankImplementation(){
            customers=new ArrayList<>();
        }
    @Override
    public void openAcc(int accNo, String firstName, String lastName,String dob, double balance,String accountType) throws CustomException {

        try{
            checkBalance(balance);
            LocalDate bdate= getAge(dob);
            customers.add(new Customer( accNo,firstName,lastName, bdate,balance,accountType));
            System.out.println("Account created successfully");
            cnt++;
        }catch (CustomException  e){
            e.printStackTrace();
        }

    };
    @Override
    public void allAccounts(){
        System.out.println(customers);
    };

    //widraw
    @Override
    public String withdraw(int accNo,double amount)throws CustomException{
        Customer customer=customers.get(customers.indexOf(new Customer(accNo)));
        double balance=sufficientBalance(customer,amount);
        customer.setBalance(balance-amount);
        return "Transaction completed !!!! available balance "+customer.getBalance();
    }
    @Override
    public  String deposit(int accNo,double amount)throws CustomException{
        Customer customer=isUserExist(customers.get(customers.indexOf(new Customer(accNo))));
        customer.setBalance(customer.getBalance()+amount);
        return "Amount added successfully!!! Balance: "+customer.getBalance();
    }
    @Override
    public String fundTrasfer(int accNo1,int accNo2,double amount)throws CustomException{
      Customer sender=  isUserExist(isUserExist(customers.get(customers.indexOf(new Customer(accNo1)))));
      Customer reciever=isUserExist(isUserExist(customers.get(customers.indexOf(new Customer(accNo2)))));
      double senderBalance=sufficientBalance(sender,amount);
            sender.setBalance(senderBalance-amount);
            reciever.setBalance(sender.getBalance()+amount);
        return "fund transfer successfully availabale balance: "+sender.getBalance();
    }
}
