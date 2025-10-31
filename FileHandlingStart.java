//Q1. check if file or directory exists or not
/*import java.util.Scanner;
import java.io.File;
public class FileHandlingStart {
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the file name or directory path name : ");
        String name= sc.nextLine();
        File file= new File(name);
        if(file.exists()){
            System.out.println("Exists");
        }else{
            System.out.println("Does not exist");
        }
    }    
}
*/


//q2 perform simple read and write opn into a file

/*import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class FileHandlingStart {
    public static void readFile(File f){
        try{
                Scanner read= new Scanner(f);
                while(read.hasNextLine()){//checks if there is another line in the file
                    String data= read.nextLine();
                    System.out.println(data);
                }
                read.close();//closing is necessary to avoid memory leaks
            }catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();}

    }
    public static void writeFile(File f){
        try{
            java.io.FileWriter writer= new java.io.FileWriter(f);
            writer.write("Hello World!\n");
            writer.write("This is a sample file.\n");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();}
    }
    public static File createFile(){
        File f= new File("Practice.txt");
        try{
            if(f.createNewFile()){
                System.out.println("File created: "+f.getName());
            }else{
                System.out.println("File already exists.");
            }}
            catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();//what is stacktrace? 
                //it is used to print the error details for debugging purposes
            }
            return f;
    }
    public static void main(String []args){
        File f= createFile();
        writeFile(f);
        System.out.println("Reading the file content:");
        readFile(f);
            
    }    
}*/

//q3 change file permissions


/*import java.io.File;
public class FileHandlingStart {
    public static void main(String []args){
        File f= new File("Practice.txt");
        if(f.exists()){
            //set file to read-only
            if(f.setReadOnly()){
                System.out.println("File set to read-only.");
            }else{
                System.out.println("Failed to set file to read-only.");
            }
            //set file to writable
            if(f.setWritable(true)){
                System.out.println("File set to writable.");
            }else{
                System.out.println("Failed to set file to writable.");
            }
        }else{
            System.out.println("File does not exist.");
        }
    }    
}
*/

//q4 write a file that reads sno, first name, cgpa, and grade into a textfile using a buffered reader
import java.io.*;
import java.util.Scanner;
public class FileHandlingStart {
    static int sno=1;
    static void serialNumberCounter(File f){
        
        
        try{
            BufferedReader br= new BufferedReader(new FileReader(f));
            String line;
            int count=0;
            while((line= br.readLine())!=null){
                count++;
            }
            sno=count+1;
            br.close();
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();}
    }
    public static String grades(float cgpa){
        String grade;
        if(cgpa>=9){
            grade="A";
        }else if(cgpa>=8){
            grade="B";
        }else if(cgpa>=7){
            grade="C";
        }else if(cgpa>=6){
            grade="D";
        }else{
            grade="F";
        }
        return grade;
    }
    public static File create(){
        File f= new File("Students.txt");
        if(!f.exists()){
            try{
                f.createNewFile();
                
            }catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else{
            serialNumberCounter(f);
        }
        return f;
    }
    public static void fileReader(File f){
        try{
            BufferedReader br= new BufferedReader(new FileReader(f));
            String line;
            System.out.println("SNo\tFirst Name\tCGPA\tGrade");
            while((line= br.readLine())!=null){
                System.out.println(line);
            }
            br.close();
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void fileWriter(File f){
        try{
            BufferedWriter bw= new BufferedWriter(new FileWriter(f,true));
            Scanner s= new Scanner(System.in);
            System.out.println("Enter First Name: ");
            String firstName= s.next();
            System.out.println("Enter CGPA: ");
            float cgpa= s.nextFloat();
            String grade= grades(cgpa);
            int sno=1;
            BufferedReader br= new BufferedReader(new FileReader(f));
            while(br.readLine()!=null){
                sno++;
            }
            br.close();
            String record= sno+"\t"+firstName+"\t"+cgpa+"\t"+grade;
            bw.write(record);
            bw.newLine();
            bw.close();
            System.out.println("Record added successfully.");
        }catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void main(String []args){
        File fileobj =create();
        Scanner s= new Scanner(System.in);
        System.out.println("Welcome to student management system ");
        while(true){
            System.out.println("Do you want to read, write, or exit? (r/w/e)");
        char choice= s.next().charAt(0);
        if(choice=='r'){
            fileReader(fileobj);
            
        }else if (choice=='w'){
            fileWriter(fileobj);
            
        }
        else if(choice=='e'){
            System.out.println("Exiting the system. Goodbye!");
            break;
            
        }else{
            System.out.println("Invalid choice. Please enter r, w, or e.");
        }
    }
    
    }
}
