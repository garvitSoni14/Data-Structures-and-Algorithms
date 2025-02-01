package Array;

import java.util.Scanner;

public class Second_Largest_Element
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
        System.out.println("The second largest element is : "+secondLargestElement(arr));
    }

    public static int secondLargestElement(int arr[])
    {
        int largest = arr[0];
        int secondLargest = arr[1];
        for(int i=0; i<arr.length; i++)
        {
            if(largest<arr[i])
            {
                secondLargest = largest;
                largest = arr[i];

            }
            else if(secondLargest < arr[i] && arr[i] < largest)
            {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
