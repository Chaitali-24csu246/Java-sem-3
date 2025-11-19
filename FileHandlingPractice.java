//program does:
//Ask reader to enter a file name
//if file exists or not
//if exists, count (no of characters, words, lines)
//closes
//then asks for input again
//don't terminate till user asks
//usec buffered reader and writer
//use split
import java.util.Scanner;
import java.io.*;
public class FileHandlingPractice {
           
      public static void main(String []args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the file name or directory path name : ");
        String name= s.nextLine();
        File file= new File(name);
        if(file.exists()){
            System.out.println("Exists");
        }else{
            System.out.println("Does not exist");
    }
}
}