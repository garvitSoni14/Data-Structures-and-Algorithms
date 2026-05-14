//BRUTE FORCE: (ARRAY WITHOUT DUPLICATES) Sort the array and return last second element [arr.length-2]. TC: O(n logn)+O(1), SC: O(n)
//BETTER APPROACH: Traverse separately for finding largest and second-largest elements. TC: O(2n), SC:(1)
//OPTIMAL APPROACH: Traverse only once and if an element is bigger than largestElement, update secondLargest and largestElement.
    // Then check if a number bigger than secondLargest and smaller than largestElement exists to update second largest.
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

    public static int secondLargestElement(int arr[]) {
        if (arr.length < 2) return -1;
        int l = Integer.MIN_VALUE, sl = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (l < arr[i]) {
                sl = l;
                l = arr[i];
            }
            if (sl < arr[i] && arr[i] < l) {
                sl = arr[i];
            }
        }
        return sl == Integer.MIN_VALUE ? -1 : sl;
    }
}

//TC: O(n)
//SC: O(1)
