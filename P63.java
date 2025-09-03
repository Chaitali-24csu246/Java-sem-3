//Multilevel Inheritance
class Account{
    int accntno;
    float balance;
}
class SavingsAccount extends Account{
    float interestRate;
    void addInterest(){
        balance+=balance*interestRate/100;
    }

}

class PremiumSavingsAccount extends SavingsAccount{
    int bonuspoints;
    void addBonusPoints(int points){
        bonuspoints+=points;
    }

}
public class P63 {
    public static void main(String args[]){
        //creating a PremiumSavingsAccount object, depositing money, applying interest, and adding bonus points.

        PremiumSavingsAccount psa=new PremiumSavingsAccount();
        psa.accntno=12345;
        psa.balance=1000;               
        psa.interestRate=5; //5%
        psa.addInterest(); //balance should now be 1050
        psa.addBonusPoints(10); //adding 10 bonus points
        System.out.println("Account No: "+psa.accntno);
        System.out.println("Balance after interest: "+psa.balance);
        System.out.println("Bonus Points: "+psa.bonuspoints);

    }
}
