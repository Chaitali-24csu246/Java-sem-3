public class Arithmetic {
    public static void main(String[] args) {
        // Variable assignment
        int a = 10;
        int b = 5;
        int c = 2;
        // Arithmetic expression with operator precedence
        int result1 = a + b * c; 
        int result2 = (a + b) * c;
        int result3 = a / b * c; /
        // Complex expression combining multiple operators
        int result4 = a + b - c * a / b; 
        
        // Printing results
        System.out.println("Result 1 (a + b * c): " + result1);
        System.out.println("Result 2 ((a + b) * c): " + result2);
        System.out.println("Result 3 (a / b * c): " + result3);
        System.out.println("Result 4 (a + b - c * a / b): " + result4);

        /* 
         Multi-line comment example:
         In Java, arithmetic operators (+, -, *, /, %) follow precedence rules.
         Parentheses can be used to override default precedence.
        */
    }
}
