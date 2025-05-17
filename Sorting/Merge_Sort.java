package Sorting;

import java.util.Arrays;

public class Merge_Sort {

    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        divide(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }

    public static void divide (int[] arr, int si, int ei)
    {
        if (si >= ei) return;
        int mid = si + (ei - si) / 2;
        divide(arr,si, mid);
        divide(arr, mid+1,ei);
        conquer(arr, si, mid, ei);
    }

    public static void conquer(int [] arr, int si, int mid, int ei)
    {
        int i= ei-si+1;
        int [] mergedArray = new int[i];
        int index1 = si;
        int index2 = mid+1;
        int x=0;
        while(index1<=mid && index2<=ei) {
            if (arr[index1] <= arr[index2]) {
                mergedArray[x++] = arr[index1++];
            } else {
                mergedArray[x++] = arr[index2++];
            }
        }
             while(index1<=mid)
             {
                 mergedArray[x++] = arr[index1++];
             }
            while(index2<=ei)
            {
                mergedArray[x++] = arr[index2++];
            }

            for(int z=0,j=si; z< mergedArray.length;z++,j++)
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
