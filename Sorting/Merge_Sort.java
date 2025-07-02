/*
MERGE SORT says that:
Divide the array in two parts, compare elements of the two parts simultaneously, place them in a sorted manner using a temporary array. Do the division until array becomes of single element.
 */
package Sorting;

import java.util.Arrays;

public class Merge_Sort {

    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }

    public static void mergeSort (int[] arr, int start, int end)
    {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr,start, mid);
        mergeSort(arr, mid+1,end);
        conquer(arr, start, mid, end);
    }

    public static void conquer(int [] arr, int start, int mid, int end)
    {
        int i= end-start+1;                      // Deciding the size of the array to store merged and sorted elements.
        int [] mergedArray = new int[i];             // Initializing the array to store merged and sorted elements.

        int left = start;
        int right = mid+1;
        int x=0;                                 // pointer for the mergedArray
        while(left <= mid && right <= end)
        {
            if (arr[left] <= arr[right]) {
                mergedArray[x++] = arr[left++];
            } else {
                mergedArray[x++] = arr[right++];
            }
        }
        while(left<=mid)
        {
            mergedArray[x++] = arr[left++];
        }
        while(right<=end)
        {
            mergedArray[x++] = arr[right++];
        }
        for(int z=0,j=start; z < mergedArray.length;z++,j++)
        {
            arr[j] = mergedArray[z];
        }
    }
}

/*
Steps:

1. If array is empty (si>=ei) return ;
2. Inside divide() function with takes array, starting index, ending index:
    3. Otherwise, calculate Middle of the current array.
    4. Recursively call divide function to work on the two arrays (starting index - mid), (mid+1 - ending index).
    5. Applly conquer method on both divided parts collectively(si, mid, ei).
6. Inside the conquer method, create a mergedArray (size similar to current array).
    7. index1 = starting of array(part1), index2 = starting of array(part2).
    8. append all the elements of divided arrays into the mergedArray.

TC: O(N log N)
SC: O(N)
 */
