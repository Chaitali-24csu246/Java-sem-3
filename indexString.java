public class indexString {
    public static void main(String []args){
        //given a string remove a character from every valid index and print at each step
        String str="chaitali";
        for(int i=0;i<str.length();i++){
            String prefix = str.substring(0, i);
            String suffix = str.substring(i + 1);
            System.out.println(prefix + suffix);}
    }
}
