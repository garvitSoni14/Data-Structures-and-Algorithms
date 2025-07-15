/*
INSERTION SORT says that:
For each element, shift all elements of left side that are larger than the present element by one index and insert the current element at its correct sorted position.
 */
package Sorting;

import java.util.Arrays;

public class Insertion_Sort
{
    public static void main(String[] args) {

        int[] a = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(insertion_sort(a)));

    }

    public static int[] insertion_sort(int[] arr)
    {
      for( int i = 1; i <= arr.length-1; i++)
      {
          int current = arr[i];
          int j = i-1;
          while( j >= 0 && arr[j] > current)
          {
              arr[j+1] = arr[j];
              j--;
          }
          arr[j+1] = current;
      }
      return arr;
    }
}

/*
Steps:

1. Run a for loop from i=0 to n-1 (till last element):
2. initialize j=i;
3. while j>0 and j th element is smaller than (j-1)th (previous adjacent):
        4. Swap them and do a j--;
5. Repeat 2 to 4 till array is sorted (upto i=n-1).
6. Return the arry.

TC: O(n^2)
SC: O(1)
*/
