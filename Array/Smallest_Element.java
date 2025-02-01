package Array;

import java.util.Scanner;

public class Smallest_Element
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Smallest element in the array is : " + smallestElement(arr));
    }
    public static int smallestElement(int arr[])
    {   int min = arr[0];
        for(int i=0; i< arr.length; i++)
        {
            if(min>arr[i])
            {
                min = arr[i];
            }
        }
        return min;
    }
}
