//BRUTEFORCE: Generate all permutations using recursion. Sort them in lexicographical order. Find the current array's poition in that list. return the right next permutation (or the first if it's the last one). TC: O(n!), SC: O( n * n!).
// OPTIMAL APPROACH: Find the first BreakPoint element from the right, swap it with the next greater element to its right, then reverse the suffix.

package Array;

import java.util.*;

public class Next_Permutation {

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int bpIndex = -1;
        // Breakpoint intex finding...
        for(int i = n-1; i>0; i--){
            if(nums[i-1] < nums[i]){
                bpIndex = i-1;
                break;
            }
        }
        //if no breakpoint
        if(bpIndex != -1){
            // finding just greated element than Breakpoint element
            int swapperIndex = Integer.MAX_VALUE;
            for(int i = n-1; i>bpIndex; i--){
                if(nums[i]>nums[bpIndex]){
                    int temp = nums[bpIndex];
                    nums[bpIndex] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            reve(nums, bpIndex+1, n-1);

        }
        else if(bpIndex == -1){
            reve(nums, 0, n-1);
        }
    }

    public static void reve(int[] nums, int start, int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        nextPermutation(arr);
        System.out.println("Next Permutation: " + arr);
    }
}
