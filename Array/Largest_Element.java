// BRUTE FORCE: We can sort the array in ascending order, hence the largest element will be at the last index of the array. TC: O(n log n)+O(1), SC: O(n)
//OPTIMAL APPROACH: Using a max variable to store the largest element by applying for loop.



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
        if (arr.length ==1) return arr[0];
        int max = arr[0];
        for(int i = 1; i <= arr.length-1; i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        return max;
    }
}

//TC: O(n)
//SC: O(1)
