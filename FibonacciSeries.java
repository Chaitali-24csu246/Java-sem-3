import java.util.Scanner;
public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n= scanner.nextInt();
        int a=0,b=1,c;
        System.out.println("Fibonacci Series up to " + n + " terms:");
        for(int i =1; i<= n;i++){
            System.out.print(a + " ");
            c =a + b;
            a= b;
            b=c;
        }}
}
