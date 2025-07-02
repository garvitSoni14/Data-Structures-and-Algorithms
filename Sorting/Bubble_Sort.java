/*
BUBBLE SORT says that:
From start -> end, repeatedly swaps adjacent elements if they are unsorted, pushing the largest unsorted element to its correct position (in the end) in each pass.
 */
package Sorting;

import java.util.Arrays;

public class Bubble_Sort {

    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(bubble_sort(a)));

    }

    private static int[] bubble_sort(int[] arr)
    {
        for(int i=0; i < arr.length-1; i++)
        {
            boolean isSwapped = false;
            for(int j=1; j<arr.length-i; j++)
            {
                if(arr[j-1] > arr[j])
                {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;

                    isSwapped = true;
                }
            }
            if(! isSwapped) break;
        }
        return arr;
    }
}

/*
Steps:

1. Loop through the array fron i=0 to n-2 (till last second element):
2. Run a nested loop from j=1 to n-i (in each pass array is getting sorted from the end,i=no. of elements sorted from end):
    3. swap if (j-1)th element > j th element.
4. Repeate from 2 to 3 till i reaches n-2.
5. Return the array.

TC: O(n^2)
best case: O(n)
SC: O(1)
 */
