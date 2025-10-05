import java.util.Scanner;
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values of a:");
        double a= scanner.nextDouble();
        System.out.println("Enter values of b:");
        double b= scanner.nextDouble();
        System.out.println("Enter values of c:");
        double c= scanner.nextDouble();
        double d=b*b-4*a*c;
        if (d >=0){
            double r1 =(-b +Math.sqrt(d))/(2 * a);
            double r2= (-b- Math.sqrt(d))/(2 * a);
            System.out.println("Roots are: " + r1 + " , " + r2);
        } else {
            System.out.println("Roots are imaginary");
        }
    }
}
