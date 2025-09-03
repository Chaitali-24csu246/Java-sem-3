class Payment{
    void processPayment(double amount){
        System.out.println("Processing payment of: "+amount);
    }
}
class CreditCard extends Payment{
    @Override
    void processPayment(double amount){
        System.out.println("Processing credit card payment of: "+amount);
    }

}
class UPI extends Payment{ 
    @Override
    void processPayment(double amount){
        System.out.println("Processing UPI payment of: "+amount);
    }

}
class Wallet extends Payment{
    @Override
    void processPayment(double amount){
        System.out.println("Processing wallet payment of: "+amount);
    }

}
public class P64 {
    public static void main(String Args[]){
        Payment[] payments=new Payment[3];
        payments[0]=new CreditCard();
        payments[1]=new UPI();
        payments[2]=new Wallet();
        double amount=1000.0;
        for(Payment p:payments){
            p.processPayment(amount);
            amount+=500; //incrementing amount for variety
        }
    }
}
