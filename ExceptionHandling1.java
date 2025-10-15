/*
 * . Write a program that asks the user to input a set of floating-point values. 
 * When the user enters a value that is not a number, give the user a second chance to 
 * enter the value. After two chances, quit reading input. Add all correctly specified values 
 * and print the sum when the user is done entering data. Use exception handling to detect improper 
 * inputs.
 */
import java.util.Scanner;
public class ExceptionHandling1 {
    public static void main(String []args){
Scanner scanner=new Scanner(System.in);
double sum=0,a=0;
while(a<2){
    System.out.println("Enter a number:");
    try {
        double n=scanner.nextDouble();
        sum+=n;
        System.out.println("Do you want to exit? y if you do.");
        char c=scanner.next().charAt(0);
        if(c=='y'){
            System.out.println("Sum is: "+sum);
            break;
        }
    } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid floating-point number.");
            a++;
            // Clear the invalid input from buffer
                scanner.nextLine();
            if(a==2){
                System.out.println("Too many invalid attempts. Exiting.");
                System.out.println("Sum is : "+sum);
                break;  }
            
}
    }
}}
