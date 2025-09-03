//Main class Animal
//in program only sleep is not overidden
class Animal{
    String picture, food,  boundaries, location;
    boolean hunger;
    //constructor
    Animal(String p, String f, boolean h, String b, String l){
        picture = p;
        food = f;
        hunger=h;
        boundaries = b;
        location = l;
    }
    //default constructor
    Animal(){

    }
    //getter
    public String getPicture(){
        return picture;
    }
    public String getFood(){
        return food;
    }
    public boolean getHunger(){
        return hunger;
    }
    public String getBoundaries(){
        return boundaries;
    }
    public String getLocation(){
        return location;
    }
    //setter
    public void setPicture(String picture){
        this.picture= picture;
    }
    public void setFood(String food){
        this.food= food;
    }
    public void setHunger(boolean hunger){
        this.hunger= hunger;
    }
    public void setBoundaries(String boundaries){
        this.boundaries= boundaries;
    }
    public void setLocation(String location){
        this.location= location;
    }
    //tostring
    @Override
    public String toString(){
        return "Animal : \n Picture : " + picture + "\n Food : " + food + "\n Hunger : " + hunger + "\n Boundaries : " + boundaries + "\n Location : " + location;
    }
    //methods
    public void makeNoise(){
        System.out.println("Animal makes noise");
    }
    public void eat(){
        System.out.println("Animal eats food");
    }
    public void sleep(){
        System.out.println("Animal sleeps");
    }
    public void roam(){
        System.out.println("Animal roams");
    }
}
//Showing inheritance 
//animal: feline(lion,cat,tiger),hippo,canine(dog wolf) all are classes
class Feline extends Animal{
    //method roam
    @Override
    public void roam(){
        System.out.println("Feline roams");
    }   
    
}
class Hippo extends Animal{
    //methods makenoise and eat
    @Override
    public void makeNoise(){
        System.out.println("Hippo makes noise");
    }
    @Override
    public void eat(){
        System.out.println("Hippo eats food");
    }
    
}
class Canine extends Animal{
    //methods roam
    @Override
    public void roam(){
        System.out.println("Canine roams");
    }
}
//feline subclasses
class Lion extends Feline{
    //makenoise eat
    @Override
    public void makeNoise(){
        System.out.println("Lion makes noise");
    }
    @Override
    public void eat(){
        System.out.println("Lion eats food");
    }
}
class Tiger extends Feline{
    //makenoise eat
    @Override
    public void makeNoise(){
        System.out.println("Tiger makes noise");
    }
    @Override
    public void eat(){
        System.out.println("Tiger eats food");
    }
   
}
class Cat extends Feline{
    //makenoise eat
    @Override
    public void makeNoise(){
        System.out.println("Cat makes noise");
    }
    @Override
    public void eat(){
        System.out.println("Cat eats food");
    }
}
//canine subclasses
class Dog extends Canine{
    //makenoise eat
    @Override
    public void makeNoise(){
        System.out.println("Dog makes noise");
    }
    @Override
    public void eat(){
        System.out.println("Dog eats food");
    }
    
}
class Wolf extends Canine{
    //makenoise eat
    @Override
    public void makeNoise(){
        System.out.println("Wolf makes noise");
    }
    @Override
    public void eat(){
        System.out.println("Wolf eats food");
    }
}
//main class
public class AnimalHierarchy {
    public static void main(String args[]){
        //superclass reference holding a subclass object
        Animal a1 = new Lion();
        a1.makeNoise();
        a1.eat();
        a1.roam();
        a1.sleep();
        System.out.println();

        Animal a2 = new Tiger();
        a2.makeNoise();
        a2.eat();
        a2.roam();
        a2.sleep();
        System.out.println();

        Animal a3 = new Cat();
        a3.makeNoise();
        a3.eat();
        a3.roam();
        a3.sleep();
        System.out.println();

        Animal a4 = new Dog();
        a4.makeNoise();
        a4.eat();
        a4.roam();
        a4.sleep();
        System.out.println();

        Animal a5 = new Wolf();
        a5.makeNoise();
        a5.eat();
        a5.roam();
        a5.sleep();
        System.out.println();

        Animal a6 = new Hippo();
        a6.makeNoise();
        a6.eat();
        a6.roam();
        a6.sleep();
        System.out.println();


    }
}
//jvm resolves from bottom to top(function overriding at runtime
//compile time polymorphism downcasting
//also check upcasting)