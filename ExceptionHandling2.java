/*
 * Create a BankAccount class that throw an IllegalArgumentException when the account 
 * is constructed with a negative balance, when a negative amount is deposited, or when an amount
 *  that is not between 0 and the current balance is withdrawn. Write a test program that causes 
 * all three exceptions to occur and that catches them all.
 */
class BankAccount{
    double balance;
    BankAccount(double balance){
        if(balance<0){
            throw new IllegalArgumentException("Balance cannot be negative");
        } 
        else{
            this.balance=balance;  
        }
    }
    void deposit(double amount){
        if(amount<0){
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        else{
            balance+=amount;
        }
    }
    void withdraw(double amount){
        if(amount<0 || amount>balance){
            throw new IllegalArgumentException("Withdraw amount must be between 0 and current balance");    }

}}
public class ExceptionHandling2 {
    public static void main(String []args){
        try{
            BankAccount account1=new BankAccount(-1000); //negative balance
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }  
        try{
            BankAccount account2=new BankAccount(5000);
            account2.deposit(-500); //negative deposit
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try{
            BankAccount account3=new BankAccount(3000);
            account3.withdraw(4000); //withdraw amount greater than balance  
    }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
