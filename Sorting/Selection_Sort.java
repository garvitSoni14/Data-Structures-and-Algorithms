/*
SELECTION SORT says that -
Find the minimum element from the unsorted portion of the array and swap it with the first element of the unsorted portion
 */
package Sorting;
import java.util.Arrays;

public class Selection_Sort
{
    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(selection_sort(a)));

    }

   public static int[] selection_sort(int[] arr)
   {
       for(int i=0; i < arr.length-2; i++)    // not iterating for the last element because it will be sorted automatically if rest of the elements are in correct position.
       {
           int minIndex = i;
           for(int j=i+1; j < arr.length; j++)
           {
               if(arr[j] < arr[minIndex]) minIndex = j;
           }
           int temp = arr[i];
           arr[i] = arr[minIndex];
           arr[minIndex] = temp;
       }
       return arr;
   }

}


/*

Steps:
1. Loop through the array from index i = 0 to n - 2:
2. Assume arr[i] is the minimum, set minIndex = i.
3. Find the minimum element in the unsorted part (i+1 to n-1):
        If arr[j] < arr[minIndex], update minIndex = j.
4. Swap arr[i] with arr[minIndex] if minIndex is different from i.
5. Repeat steps 1-3 until the entire array is sorted.
6. Return array


TC: O(n^2)
SC: O(1)
 */


