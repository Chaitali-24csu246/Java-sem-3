//step 3
class InvalidTransactionException extends Exception{//custom exception
    public InvalidTransactionException(String message){
        super(message);
    }}
class SmartBank{
    //step 1
    String holdername;
    double balance;
    SmartBank(String name, double b){
        if(b<0) throw new IllegalArgumentException("Opening balance cannot be negative");
        holdername=name;
        balance=b;
    }
    void deposit(double amount) throws InvalidTransactionException{
        //step 3 change
        //if(amount<0) throw new IllegalArgumentException("Cannot deposit a negativ e amount");
        if(amount<0) throw new InvalidTransactionException("Cannot deposit a negative amount");
        balance+=amount;
        System.out.println("Deposited "+amount+" New balance: "+balance);
        
    }
    void withdraw(double amount) throws InvalidTransactionException{
        //if(amount<0) throw new IllegalArgumentException("Cannot withdraw a negative amount");
        //if(amount>balance) throw new IllegalArgumentException("Insufficient funds");
        //step 3 change
        if(amount<0) throw new InvalidTransactionException("Cannot withdraw a negative amount");
        if(amount>balance) throw new InvalidTransactionException("Insufficient funds");
        balance-=amount;
        System.out.println("Withdrew "+amount+" New balance: "+balance);
    }
    //transfer step 2
    //check thread sleep 
    //check logic again at home
    //throw interrupted exception in this method
    void transfer(SmartBank toAccount, double amount) throws InterruptedException, InvalidTransactionException {
        //manually throw interruptedexception here if withdrawal > balance interrupted exception throw
        if(amount>this.balance) throw new InterruptedException("Insufficient funds for transfer., interrupting transfer.");
        System.out.println("Processing transfer of " + amount + " to " + toAccount.holdername);
        Thread.sleep(500); // artificial delay
        this.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transfer complete.");
    }
}
public class BankApp {
    
    public static void main(String []args){
        //step 1
        SmartBank a1=new SmartBank("Chaitali",9999999);//valid so no try catch
        try{
        SmartBank a2 = new SmartBank("Vasvi",-9999);}

        catch(IllegalArgumentException e){
            System.out.println("Account creation failed: "+e.getMessage());
        }   
        try{
        a1.deposit(1000);
        a1.withdraw(500);
        }//catch(IllegalArgumentException e){
        catch(InvalidTransactionException e){
            System.out.println("Transaction failed: "+e.getMessage());
        }
        try{
            a1.deposit(-100);
        }//catch(IllegalArgumentException e){
        catch(InvalidTransactionException e){
            System.out.println("Deposit failed: "+e.getMessage());      
        }
        try{
            a1.withdraw(20000);

        }//catch(IllegalArgumentException e){
        catch(InvalidTransactionException e){
            System.out.println("Withdrawal failed: "+e.getMessage());}
       /*  try {
            System.out.println ("Can we add to an invalid account?");
            // no as a2 does not exist
            //a2.deposit(100);
        } catch (Exception e) {
        }*/
        //Transfer implementation
        //step 2
        SmartBank a3=new SmartBank("Vasvi",58900);
        try{
            a1.transfer(a3,2000);
        }catch(InvalidTransactionException e){
            System.out.println("Transfer failed: "+e.getMessage());
        }catch(InterruptedException e){
            System.out.println("Transfer interrupted: "+e.getMessage());    }
        //transfer where exception called in transfer interruptedexception 
        try{
            a1.transfer(a3,2000000000);
        }catch(InvalidTransactionException e){
            System.out.println("Transfer failed: "+e.getMessage());
        }catch(InterruptedException e){
            System.out.println("Transfer interrupted: "+e.getMessage());    }
        //nested try catch and finally
        //add a loop that keeps using transfer continuously until interruptedexception is thrown
        //use thread sleep to simulate delay

        //step 3
        try {
            throw new InvalidTransactionException("This is an invalid transaction");  
        }
        catch (InvalidTransactionException  ex) {
            System.out.println("Caught");  
            System.out.println(ex.getMessage());  

    }
    //step 4
    /*
     * try{
     * try catch
     * try catch} catch
     * finall;y
     */
    try{//main try 
        //1
        try{
            a1.deposit(-500);
        }catch(InvalidTransactionException e){
            System.out.println("Inner Catch 1 Deposit failed: "+e.getMessage());
        }
        //2
        try{
            a1.transfer(a3,999999999);
        }catch(InvalidTransactionException e){
            System.out.println("Inner Catch 2 Transfer failed: "+e.getMessage());
        }catch(InterruptedException e){
            System.out.println("Inner Catch 2 Transfer interrupted: "+e.getMessage());
        }} catch(Exception e){//main catch
            System.out.println("Outer Catch Transaction session ended with exception: "+e.getMessage());
        }finally{
            System.out.println("Final balance of main Account :" + a1.balance) ;  
            System.out.println("Transaction session ended");
         }


}
}
