// BRUTEFORCE: Using two nested loops, make all possible subarrays and sum up its elements if the sum==0, store the size of lasrgest subarray occured till now in "max" variable.TC: O(n^2), SC: O(1).
// Traverse the array maintaining a running prefix sum, store the first occurrence index of each sum in a map, and whenever the same sum reappears (or sum becomes zero) update the maximum subarray length.
package Array;

import java.util.HashMap;

public class Longest_Subarray_With_Sum_0 {

    public static void main (String [] args){
//        int arr[] ={6, -2, 2, -8, 1, 7, 4, -10};
        int arr[] = {9, -3, 3, -1, 6, -5};
        System.out.println(longestSubarray(arr));
    }

    public static int longestSubarray(int [] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxlen = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) maxlen = i + 1;
            if (hm.containsKey(sum)) {
                maxlen = Math.max(maxlen, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }

        }
        return maxlen;
    }
// TC: O(n)
// SC: O(n)


        public static int longestSubarray_BRUTEFORCE( int[] arr){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                int sum = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    sum += arr[j];
                    if (sum == 0) {
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
            return max;
        }
    }
