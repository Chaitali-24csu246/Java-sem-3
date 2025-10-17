/* 
Step 2 — throw vs throws 
Goal: introduce a checked exception path with throws.

In SmartBank, add a transfer(toAccount, amount) method that:

Prints a “processing” message.

Performs a small artificial delay that requires you to declare a checked exception using throws.

Internally calls withdraw on the sender and deposit on the receiver.

In BankApp.main, wrap a call to transfer in try/catch and handle the checked exception.

Observe/Record: What compiler hint/error appears if you omit the throws in the method signature? How is this different from unchecked exceptions in Step 1?

Checkpoint: You can now explain throw (create/trigger) vs throws (declare/propagate).

Step 3 — Custom Checked Exception 
Goal: model a business rule with a custom exception.

Create a new class InvalidTransactionException extending Exception (checked).

Update deposit and withdraw to:

Throw this custom exception for non-positive amounts.

Throw this custom exception for insufficient funds.

Update method signatures to declare they throws this exception.

In BankApp.main, add:

A try/catch around a negative deposit call → print a clear message using the exception.

A try/catch around a zero withdrawal call → print the message.

Observe/Record: Which methods now force you to handle/declare? Why is this better than generic runtime exceptions for business rules?

Checkpoint: You can use a custom checked exception and see how it enforces handling.

Step 4 — Nested Try/Catch + Finally 
Goal: show granular handling and cleanups.

In BankApp.main, create a single outer try block for a transaction session.

Inside it, create two inner try/catch blocks:

Inner #1: Call a deposit that fails with your custom exception → catch locally and print a friendly message.

Inner #2: Call transfer that fails (e.g., amount higher than balance) → catch the appropriate exception locally and print a message.

After the two inner blocks, still inside the outer try, call a withdrawal that fails with your custom exception. Let it bubble to the outer catch.

Add a finally block on the outer try that prints:

The final balance of the main account

A “transaction session complete” message

Observe/Record: Which exceptions were handled locally vs bubbled up? Did the finally block execute regardless of failures?

Checkpoint: You’ve demonstrated nested handling, propagation, and finally.

Optional Stretch (if you finish early)
Add a safeTransfer wrapper that calls transfer and catches any exception internally, printing a single “Transfer failed” line.

Replace a specific catch with a multi-catch that handles two unrelated exception types in one block.

Print the exception class name and a short tip (“Try a smaller amount”) for better UX.
 */
class SmartBank{
    String holdername;
    double balance;
    SmartBank(String name, double b){
        if(b<0) throw new IllegalArgumentException("Opening balance cannot be negative");
        holdername=name;
        balance=b;
    }
    void deposit(double amount){
        if(amount<0) throw new IllegalArgumentException("Cannot deposit a negativ e amount");
        balance+=amount;
        System.out.println("Deposited "+amount+" New balance: "+balance);
        
    }
    void withdraw(double amount){
        if(amount<0) throw new IllegalArgumentException("Cannot withdraw a negative amount");
        if(amount>balance) throw new IllegalArgumentException("Insufficient funds");
        balance-=amount;
        System.out.println("Withdrew "+amount+" New balance: "+balance);
    }
    //transfer
    void transfer(SmartBank toAccount, double amount) throws InterruptedException {
        System.out.println("Processing transfer of " + amount + " to " + toAccount.holdername);
        Thread.sleep(50000); // artificial delay
        this.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transfer complete.");
    }

}
public class BankApp {
    public static void main(String []args){
        SmartBank a1=new SmartBank("Chaitali",9999999);
        try{
        SmartBank a2=new SmartBank("Vasvi",-9999);}
        catch(IllegalArgumentException e){
            System.out.println("Account creation failed: "+e.getMessage());
        }   
        a1.deposit(1000);
        a1.withdraw(500);
        try{
            a1.deposit(-100);
        }catch(IllegalArgumentException e){
            System.out.println("Deposit failed: "+e.getMessage());      
        }
        try{
            a1.withdraw(20000);
        }catch(IllegalArgumentException e){
            System.out.println("Withdrawal failed: "+e.getMessage());}
       /*  try {
            System.out.println ("Can we add to an invalid account?");
            // no as a2 does not exist
            //a2.deposit(100);
        } catch (Exception e) {
        }*/
        //Transfer implementation
        SmartBank a3=new SmartBank("Vasvi",58900);
        try{
            a1.transfer(a3,2000);
        }catch(IllegalArgumentException e){
            System.out.println("Transfer failed: "+e.getMessage());
        }catch(InterruptedException e){
            System.out.println("Transfer interrupted: "+e.getMessage());    }
        //transfer where exception called in transfer interruptedexception 
        try{
            a1.transfer(a3,2000000000);
        }catch(IllegalArgumentException e){
            System.out.println("Transfer failed: "+e.getMessage());
        }catch(InterruptedException e){
            System.out.println("Transfer interrupted: "+e.getMessage());    }
        //nested try catch and finally
        
    }

}
