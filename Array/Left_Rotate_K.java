package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Left_Rotate_K
{
    public static void main(String[] args)
    {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the size of the array: ");
//        int size = scanner.nextInt();
//        int arr[] = new int[size];
//        for(int i = 0; i<size; i++)
//        {
//            System.out.println("Enter the element at index " + i + ": ");
//            arr[i] = scanner.nextInt();
//        }
        int arr[] = {1,2,3,4,5,6};
        leftRotateByk(arr,3);
        System.out.println("Left rotated array by One : "+ Arrays.toString(arr));
    }

    public static void leftRotateByk(int arr[], int k)
    {
        reverseArray(arr,0,k-1);
        reverseArray(arr,k,arr.length-1);
        reverseArray(arr,0, arr.length-1);
    }

    public static void reverseArray(int arr[], int startIndex, int endIndex)
    {
        while(startIndex <= endIndex)
        {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++ ;
            endIndex--;
        }
    }




}
