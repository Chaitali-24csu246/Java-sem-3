//loosely coupled calculator progtam
// abstraction (contract)
interface Operation {
    int apply(int a, int b);
}

class Addition implements Operation {
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}

class Subtraction implements Operation {
    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
// Calculator depends on the interface, not concrete classes
class Calculator {
    public int calculate(Operation op, int a, int b) {
        return op.apply(a, b);
    }
}    
public class CalculatorAppLooselyCoupled {
    public static void main(String args[]){
        Calculator clc = new Calculator();
        System.out.println("Add: " + clc.calculate(new Addition(), 10, 5));
        System.out.println("Subtract: " + clc.calculate(new Subtraction(), 10, 5));
       
    }
}
