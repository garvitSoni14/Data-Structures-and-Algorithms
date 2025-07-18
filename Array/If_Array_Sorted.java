// BRUTE FORCE: For each element check rest of the right side of array and if any element smaller than it is found, return false. TC:(n^2), SC: O(1).
// OPTIMAL APPROACH: In a single iteration from 0 to second last element, if i th element is > i+1 th element, return false. we chose to traverse only
        // upto second last element because if we traverse for i=last, then it will give out of bound error when we check i+1 th element with it.

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
        for(int i=0; i <= arr.length -2; i++)
        {
            if(arr[i]>arr[i+1])
            {
                return false;
            }
        }
        return true;
    }

}
// TC: O(n)
// SC: O(1)
