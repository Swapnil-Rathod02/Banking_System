package app.service;

import app.bankExecption.CustomException;

public interface BankOperation {
    public void openAcc(int accNo, String firstName, String lastName,String dob, double balance,String accountType) throws CustomException;
    public void allAccounts();
    public String widraw(int accNo,double amount) throws CustomException;
    public  String deposit(int accNo,double amount)throws CustomException;
    public String fundTrasfer(int accNo1,int accNo2,double amount)throws CustomException;
}
