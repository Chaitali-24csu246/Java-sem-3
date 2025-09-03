//program to display basic runtime polymorphism/ overriding
class Vehicle{
void rentCost(){
System.out.println("Rent method in Superclass");
}
}
class Car extends Vehicle{
    @Override//override is not necessary but it helps clear confusion
    void rentCost(){
        System.out.println("1500 per day");
}}
class Bike extends Vehicle{
    @Override
    void rentCost(){
        System.out.println("500 per day");
    }
}
class Truck extends Vehicle{
    @Override
    void rentCost(){
        System.out.println("3000 per day");
    }
    }

public class P62 {
    public static void main(String args[]){
        Vehicle v;//reference variable initialised, saving deleting reusing
        v=new Vehicle();
        v.rentCost();
        v=new Car();
        v.rentCost();//calls car rentcost
        v=new Bike();
        v.rentCost();//calls bike rentcost
        v=new Truck();
        v.rentCost();//calls truck rentcost
        //or we can create individual objects without saving to variable
        new Car().rentCost();
        new Bike().rentCost();
        new Truck().rentCost();
    }
}
