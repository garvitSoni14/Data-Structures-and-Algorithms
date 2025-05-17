package Sorting;

import java.util.Arrays;

public class Recursive_Insertion_Sort {

    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        rec_insertion_sort(a, a.length);
        System.out.println(Arrays.toString(a));

    }

  public static void rec_insertion_sort(int [] arr, int n)
  {
      if(n<=1) return;

      int last = arr[n-1];
      int j = n-2;

      rec_insertion_sort(arr,n-1);

      while(j>=0 && arr[j]>last)
      {
          arr[j+1] = arr[j];
          j--;
      }
      arr[j+1] = last;
  }
}
