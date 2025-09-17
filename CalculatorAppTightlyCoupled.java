/*You’re designing a calculator app that can perform different operations: addition, subtraction, multiplication, and division.
Task:
Create a tightly coupled version:
In the CalculatorApp main class, directly create and use Addition, Subtraction, etc. classes.
Show how switching to another operation requires modifying client code.*/

//Tightly coupled: Classes depend heavily on each other. Changing one requires changes in others.

class Calculator {//one class for all operations
    int a,b;
    Calculator(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int add() {
        return a + b;
    }
    public int subtract() {
        return a - b;
    }
    public int multiply() {
        return a * b;
    }
    public int divide() {
        return a / b;
    }
}
public class CalculatorAppTightlyCoupled {
    public static void main(String args[]){
        Calculator c= new Calculator(1,2);
        System.out.println("Addition: " + c.add());
        System.out.println("Subtraction: " + c.subtract());
        System.out.println("Multiplication: " + c.multiply());  
        System.out.println("Division: " + c.divide());

    }
}
//here we can also use separate classes for addtion, subtraction
//this will require modification and adding additional code for modulo
//for tight coupling to really show, you typically need a central class (like Calculator) that knows about all the other classes (Addition, Subtraction, etc.).

//Without it, your Main class would just create and call Addition or Subtraction directly.

//That would just be independent classes, not really "tightly coupled" design.

//So, in a tight coupling design, the "tying" class (like Calculator) is the hub that locks everything together.

//Also tightly coupled
/*class Addition {
    public int apply(int a, int b) {
        return a + b;
    }
}

class Subtraction {
    public int apply(int a, int b) {
        return a - b;
    }
}

// Tying class → Calculator knows exactly which classes to use
class Calculator {
    private Addition add;
    private Subtraction sub;

    public Calculator() {
        add = new Addition();
        sub = new Subtraction();
    }

    public int add(int a, int b) { return add.apply(a, b); }
    public int subtract(int a, int b) { return sub.apply(a, b); }
}
 */