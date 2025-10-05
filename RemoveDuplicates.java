import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        int temp[] = new int[5];
        int size = 0;
        for (int i = 0; i < 5; i++) {
            boolean duplicate = false;
            for (int j = 0; j < size; j++) {
                if (arr[i] == temp[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                temp[size] = arr[i];
                size++;
            }
        }
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < size; i++) {
            System.out.print(temp[i] + " ");
        }
    }
}
