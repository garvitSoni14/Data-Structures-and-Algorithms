package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter the element at " + i + " : ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Reverse array is : " + Arrays.toString(reverseArray(arr)));
    }

    public static int[] reverseArray(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size/2; i++) {
            swapElement(arr, i, (size - 1 - i));
        }
        return arr;
    }


    public static void swapElement(int arr[], int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
