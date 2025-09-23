class BankAccount{
    int accountNumber;
    double balance;
    static float interestRate=5;
    static int totalAccounts=0;
    BankAccount(int accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
        totalAccounts++;
    }
    void deposit (double doubleAmount){
        balance+=doubleAmount;
    }
    void withdraw (double doubleAmount){
        if (balance>=doubleAmount){
            balance-=doubleAmount;
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    void displayAccountInfo(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Balance: "+balance);
        System.out.println("Interest Rate: "+interestRate);
    }
   static void setInterestRate(float newRate){
        interestRate=newRate;
    }

}
public class classexerciseunit2 {
    public static void main(String[] args) {
        BankAccount a1=new BankAccount(12345, 1000000);
        BankAccount a2= new BankAccount(678910, 800);
        BankAccount a3= new BankAccount(111213,34506.78);
        System.out.println("Bank Account 1 info:");
        
        a1.displayAccountInfo();
        System.out.println("Bank Account 2 info:");
        a2.displayAccountInfo();
        System.out.println("Bank Account 3 info:");
        a3.displayAccountInfo();
        System.out.println("Total Accounts: "+BankAccount.totalAccounts);
        System.out.println("After performing the following transactions:");
        a1.deposit(50000);
        a2.withdraw(100);
        a3.withdraw(40000);
        a3.deposit(10000);
        System.out.println("1)Deposit of 50000 in account 1\n2)Withdrawing 100 from account 2 \n3)Withdrawing 40000 from account 3 \n4)Deposit of 10000 in account 3");
        System.out.println("Bank Account 1 info:"); 
        a1.displayAccountInfo();
        System.out.println("Bank Account 2 info:");
        a2.displayAccountInfo();
        System.out.println("Bank Account 3 info:");
        a3.displayAccountInfo();
        //Use the static method to change the interest rate and show how it affects all accounts.
        BankAccount.setInterestRate(6);
        System.out.println("After changing the interest rate to 6%");
        System.out.println("Bank Account 1 info:"); 
        a1.displayAccountInfo();
        System.out.println("Bank Account 2 info:");
        a2.displayAccountInfo();
        System.out.println("Bank Account 3 info:");
        a3.displayAccountInfo();
        
    }
}
