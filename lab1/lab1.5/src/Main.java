import java.sql.Array;

public class Main {
    public static void main(String[] args) {
        int len = 5;
        int arr[] = {1,2,3,4,5};
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        MoveToRight(arr,arr.length);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void MoveToRight(int arr[],int lenght){
        int temp = arr[lenght-1];
        for (int i = lenght-1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
}