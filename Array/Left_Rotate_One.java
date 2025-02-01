package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Left_Rotate_One
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i = 0; i<size; i++)
        {
            System.out.println("Enter the element at index " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        leftRotateByOne(arr);
        System.out.println("Left rotated array by One : "+ Arrays.toString(arr));
    }

    public static void leftRotateByOne(int arr[])
    {
        int first = arr[0];
        for(int i = 1; i<arr.length; i++)
        {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = first;
    }
}

