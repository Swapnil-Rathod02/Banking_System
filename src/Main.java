import app.bankExecption.CustomException;
import app.service.BankImplementation;
import app.service.BankOperation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner sc=new Scanner(System.in)){
            BankOperation bankOperation=new BankImplementation();
            boolean exit=false;
            while(!exit){
                try{
                System.out.println("1.open account 2.display opened account 3.widraw money 4.deposit 5.exit");
                switch (sc.nextInt()){
                    case 1:
                        System.out.println("Enter 1.account number 2.first name 3.last name 4.Birthdate 5.balance and 6.account type");
                        bankOperation.openAcc(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next());
                                break;
                    case 2:
                        System.out.println("customers in bank");
                        bankOperation.allAccounts();
                        break;
                    case 3:
                        System.out.println("Enter account number and amount");
                        System.out.println(bankOperation.withdraw(sc.nextInt(),sc.nextDouble()));
                        break;
                    case 4:
                        System.out.println("Enter account and money to deposit");
                        System.out.println(bankOperation.deposit(sc.nextInt(),sc.nextDouble()));
                        break;
                    case 5:
                        exit=true;
                    default:
                        System.out.println("choose valid option");
                }
            }catch (CustomException o){
                    o.printStackTrace();
                }catch (InputMismatchException i){
                    i.printStackTrace();
                    sc.nextLine();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}