// BRUTE FORCE: Store the first element in temp, create anew array and store rest of theelements in it from start, in the end put the temp element in it. TC: O(n), SC: O(n)
// OPTIMAL APPROACH:  store first element in a temp, shift all elements to the left by one index from index 1 , and place temp in the last of array.
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

// TC: O(n)
// SC: O(1)

