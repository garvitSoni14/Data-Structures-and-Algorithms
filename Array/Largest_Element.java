package Array;

import java.util.Scanner;

public class Largest_Element
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
        System.out.println("Largest Element in the array is: " + largestElement(arr));
    }

    public static int largestElement(int arr[])
    {
        int max = arr[0];
        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        return max;
    }
}
