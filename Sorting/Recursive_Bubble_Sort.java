package Sorting;

import java.util.Arrays;

public class Recursive_Bubble_Sort {

    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        rec_bubble_sort(a,a.length);
        System.out.println(Arrays.toString(a));

    }

    public static void rec_bubble_sort(int[] arr, int n)
    {
        if(n==1) return;

        for (int j = 1; j < n; j++) {
            if (arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
            }
        }
        rec_bubble_sort(arr,n-1);
    }

}
