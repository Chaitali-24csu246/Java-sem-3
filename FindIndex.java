import java.util.Scanner;
public class FindIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arr[] ={1,2,3,4,5,6,7};
        System.out.print("Enter number to search: ");
        int num = scanner.nextInt();
        System.out.println("Array elements are:");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int index=-1;
        int found=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                index = i;
                found=1;
                break;
            }
        }
        if(found==0){
            System.out.println("Not found");
        }else{
        System.out.println("Index of " + num + " = " + index);}
    }
}
