/*
QUICK SORT says that:
Pick an element as Pivot (it can be any number-start/end/mid..., we are taking the end element in our algorithm),
move all elements which are smaller than the Pivot element to the left and larger elements to the right.
Do this recursively for both partitions until there is only one element left in the last partition.
 */
package Sorting;

import java.util.Arrays;

public class Quick_Sort {

    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        quick_sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quick_sort(int[] arr, int start, int end)
    {
        if(start<end)
        {
            int pivot = partition(arr, start, end);
            quick_sort(arr,start,pivot-1);
            quick_sort(arr, pivot+1, end);

        }
    }
    public static int partition(int [] arr, int start, int end) {
        int index = start - 1;
        int pivotElement = arr[end];
        for (int j = start; j <= end-1; j++) {
            if (arr[j] <= pivotElement) {
                index++;
                int temp = arr[index];
                arr[index] = arr[j];
                arr[j] = temp;
            }

        }
        index++;
        int temp = arr[index];
        arr[index] = arr[end];
        arr[end] = temp;
        return index;
    }

    public static void swap(int[] arr, int x, int y)
    {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}

/*

Steps:

1. Quick_sort ( array , starting index , ending index ):
    2. if ( array is non empty ):
        3. choose a pivote element by partition method.
        3. recursively call the quick sort for two divided arrays ( starting index - pivot - 1 ) and ( pivot + 1, ending index)
4. Partition method ( array ,  starting index, ending index ):
    5. index = si - 1.
    6. pivot = last element of current array.
    7. for loop ( starting index - ending index):
        8. if current element id smaller than pivot, swap the indices.
    9. index++;
    10. swap index with ending index.
    11 return index ( partitioning element ).

TC:
Best and Average Cases: O( N Log N):
    If the pivot divides the array into two equal halves every time:
                n   -> Total elements to sort
               / \
             n/2  n/2  -> Two subproblems
            / \   / \
         n/4 n/4 ...and so on
    At each level: work = O(n) (partitioning the entire array)
    Number of levels = log n (because array size gets halved each time)

WorstCase: O(n^2) :
    If the pivot is always the smallest or largest element:
    One part will have 0 elements
    The other will have n-1 elements
                n
               /
             n-1
             /
           n-2
    The array is already sorted (ascending or descending).
    The pivot choice is always bad (like always choosing the last element, as in your code).
SC: O( 1 )
    Every recursive call adds a new function to the call stack, which takes space.Best Case Space Complexity: O(log n)
    If the pivot divides the array evenly every time:
    Depth of recursion = log n
    So, only log n recursive calls are on the call stack at any time.
 */