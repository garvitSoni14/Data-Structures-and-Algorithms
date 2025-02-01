package Array;

import java.util.Scanner;

public class Sum_Of_Array_Elements
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i=0; i<size; i++)
        {
            System.out.print("Enter the element at " + i + " : ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("The sum is : "+ sumArray(arr));
    }

    public static int sumArray(int arr[])
    {
        int sum = 0;
        for(int i=0; i<arr.length; i++)
        {
            sum+=arr[i];
        }
        return sum;
    }

}
