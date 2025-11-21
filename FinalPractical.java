import java.io.*;
import java.util.*;
public class FinalPractical {
    public static void main(String[] args) {
        //Scanner s=new Scanner(System.in);
        //String filename=s.getLine();
        File javaFile = new File("BankApp.java");
        File allowedFile = new File("allowed_identifiers.txt");
        try {
            BufferedReader allowedReader = new BufferedReader(new FileReader(allowedFile));//reader added to buffered reader
            //buffered reader does not red files directly, it reads anither reader
            Set<String> allowedIdentifiers = new HashSet<>();//no duplicacy
            //variablev length
            String line;
            while ((line = allowedReader.readLine()) != null) {//must repeat reader in every loop 
                allowedIdentifiers.add(line.trim());   //trim to remove extra spaces     
            }
            allowedReader.close();//avoid memory leak
            BufferedReader javaReader = new BufferedReader(new FileReader(javaFile));
            StringBuilder content = new StringBuilder();//mutable
            while ((line = javaReader.readLine()) != null) {//going through java file and adding it to StringBuilder content
                content.append(line).append(" ");//append with space for separation
            }
            javaReader.close();

            String[] tokens = content.toString().split("[^a-zA-Z_]+");//splitting content to make a strinarray
            //needs to be string because stringbuilder has no split
            Set<String> unknownIdentifiers = new java.util.HashSet<>();

            Set<String> javaKeywords = new HashSet<>(Arrays.asList(//what does arrays aslist do: converts array to list
                //retrieved this list online
                "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class",
                "const", "continue", "default", "do", "double", "else", "enum", "extends", "final",
                "finally", "float", "for", "goto", "if", "implements", "import", "instanceof",
                "int", "interface", "long", "native", "new", "package", "private", "protected",
                "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
                "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
            ));
//we are using list here beacuse: no repetition
//array would have been faster but we need to check contains method which is not there in array
            //token by token check
            for (String token : tokens) {//going through javba file values
                if (!token.isEmpty() && !javaKeywords.contains(token) && !allowedIdentifiers.contains(token)) {//not empty, not a java identifier, not in txt file
                    unknownIdentifiers.add(token);
                }
            }
//printing
            System.out.println("Unknown Identifiers:");
            for (String id : unknownIdentifiers) {
                System.out.println(id);
            }
            System.out.println("Total unknown identifiers: " + unknownIdentifiers.size());

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());//filenotfound, io, eof
        }
    }

}   