package Sorting;

import java.util.Arrays;

public class Quick_Sort {

    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        quick_sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    public static void quick_sort(int[] arr, int si, int ei)
    {
        if(si<ei)
        {
            int pivot = partition(arr, si, ei);
            quick_sort(arr,si,pivot-1);
            quick_sort(arr, pivot+1, ei);

        }
    }
    public static int partition(int [] arr, int si, int ei) {
        int index = si - 1;
        int pivot = arr[ei];
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                index++;
                swap(arr, j, index);
            }

        }
        index++;
        swap(arr, ei, index);
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

TC: O( N log N )
SC: O( N )
 */