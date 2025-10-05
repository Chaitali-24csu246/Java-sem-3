import java.util.Scanner;
public class VowelConsonant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
  System.out.print("Enter a single character: ");
        String s = scanner.next();
        if(s.length() != 1 || !Character.isLetter(s.charAt(0))){
            System.out.println("Error: Please enter only one alphabet letter.");
        } else {
            char ch = Character.toLowerCase(s.charAt(0));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                System.out.println("Vowel");
            else
                System.out.println("Consonant");
        }
    }
}
