// BRUTEFORCE: Use thre nested loop, find MaxSUbarraySUm, return the array portion of maxSumSubarray.
// BETTER APPROACH: Use two nested loops, and do the same as brute force approach.
// OPTIMAL APPROACH: (KADANE MODIFIED), Inside a loop, if currentSum+arr[i] < arr[i] -> i will be new
    // subarray starting, but if not, then just add arr[i] in currentSubarraySum, now if currentSubarraySum>maxSum,
    // set it to maxSum, and end =i ,then return the portion of subarray with start, end+1.
package Array;

import java.util.Arrays;

public class Return_Subarray_With_MaxSum {

    public static void main(String [] args){
        int [] sample= {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(maxSumSubarray(sample)));
    }

    public static int[] maxSumSubarray(int [] arr){
        int maxSum=arr[0];
        int currentSum=arr[0];
        int start = 0, end = 0, tempStart=0;
        for(int i=1; i<arr.length; i++){
            if(currentSum+arr[i]<arr[i]){
                currentSum=arr[i];
                tempStart = i;
            }
            else {
                currentSum+=arr[i];
            }
            if(currentSum>maxSum){
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        return Arrays.copyOfRange(arr,start, end+1);
    }

// TC: O(n)
// SC: O(1)

    public static int[] maxSumSubarray_BETTERFORCE(int[] arr){
        int maxSum=0, start=0, end=0;
        for(int i=0;i<arr.length; i++){
            int currentSum=0;
            for(int j=i; j<arr.length;j++){
                currentSum+=arr[j];
                if(currentSum>maxSum){
                    maxSum = currentSum;
                    start = i; end = j;
                }
            }
        }
        return Arrays.copyOfRange(arr, start, end+1);
    }
}
