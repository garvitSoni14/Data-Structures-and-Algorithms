package Array;

import java.util.Scanner;

public class If_Array_Sorted
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int arr[] = new int[size];
        for(int i=0; i<size;i++)
        {
            System.out.println("Enter the element at "+ i + " : ");
            arr[i] = scanner.nextInt();
        }
        System.out.println(ifArraySorted(arr));
    }

    public static boolean ifArraySorted(int arr[])
    {
        for(int i=0; i < arr.length -1; i++)
        {
            if(arr[i]>arr[i+1])
            {
                return false;
            }
        }
        return true;
    }

}
