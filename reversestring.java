public class reversestring {
    public static void main(String []args){
        String original = "Good gooder goodest, good better best";
        System.out.println("Original string is: " +original);
        char[] charArray=original.toCharArray();
        char[] rev = new char[charArray.length];
        for(int i=charArray.length-1,j=0; i>=0;i--, j++){
            rev[j] = charArray[i]; 
        }
        String ans =new String(rev);
        System.out.println("Reversed string is: " + ans);
        //only words reverse
        String str="Good gooder goodest, good better best";
        String[] arr= str.split(" ");
        for(int i=arr.length-1;i>=0;i--){
            System.out.print(arr[i] + " ");
        }
     }
}