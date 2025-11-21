//program does:
//Ask reader to enter a file name
//if file exists or not
//if exists, count (no of characters, words, lines)
//closes
//then asks for input again
//don't terminate till user asks
//usec buffered reader and writer
//use split
import java.io.*;
import java.util.Scanner;
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
        try{
            BufferedReader br= new BufferedReader(new FileReader(file));
            String line;
            int charCount=0;
            int wordCount=0;
            int lineCount=0;
            while((line=br.readLine())!=null){
                lineCount++;
                charCount+=line.length();
                String[] words=line.split("\\s+");
                wordCount+=words.length;
            }
            br.close();
            System.out.println("Number of characters: " + charCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);
        }catch(IOException e){
            System.out.println("An error occurred while reading the file.");
        }
}
}