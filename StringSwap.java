import java.util.Scanner;
public class StringSwap {
    public static void main(String []args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter a string:");
        String str=s.nextLine();
        char[] charArray = str.toCharArray();
        for(int i=0;i<charArray.length-1;i++){
            char temp = charArray[i];
            charArray[i] = charArray[i+1];
            charArray[i+1] = temp;
            System.out.println(new String(charArray));
            temp = charArray[i];
            charArray[i] = charArray[i+1];
            charArray[i+1] = temp;      
        }
    }
}
