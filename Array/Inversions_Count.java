// BRUTEFORCE: Compare every pair (i, j) with i < j and increment count whenever arr[i] > arr[j]. TC: O(n²), SC: O(1)
// OPTIMAL APPROACH: Recursively divide the array into halves, count inversions while merging by adding (mid - left + 1) whenever arr[left] > arr[right].
    // TC: O(n log n), SC: O(n)
package Array;

import java.util.ArrayList;

public class Inversions_Count {
    public static void main(String[] args) {
        int[] sample = {5, 4, 3, 2, 1};
        System.out.println(inversionCount(sample, sample.length)); // expected 10
    }

    public static int inversionCount(int[] a, int n) {
        return mergeSort(a, 0, n - 1);
    }

    public static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int count = 0;

        // Merge two sorted halves and count inversions
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                count += (mid - left + 1); // All remaining elements in left half are greater
                right++;
            }
        }

        // Add remaining elements from left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Add remaining elements from right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy merged elements back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) return count;
        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    // Brute force version
    public static int inversionCount_BRUTEFORCE(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
