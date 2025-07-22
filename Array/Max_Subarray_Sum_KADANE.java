//BRUTEFORCE: We will run 3 nested loops and find all possible subarrays and store the sum of these subarray's elements in currentSum, then return the maxium of previous sum and current sum. TC: O(n^3), SC; O(1).
// BETTER APPROACH: We will run 2 nested loops, and find all possible subarrays, and do the same like BRUTEFORCE. TC: O(n^2), SC: O(1).
//OPTIMAL APPROACH: (KADANE-ALGORITHM) At each index, we decide to either extend the previous subarray or start a new one, and update the maximum seen so far.
package Array;

public class Max_Subarray_Sum_KADANE {

    public static void main(String[] args){
        int [] sample = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(kadaneAlgo(sample));

    }

    public static int kadaneAlgo(int [] arr){
        int currentSum=arr[0], maxSum=arr[0];
        for(int i=0; i<arr.length; i++){
            currentSum = Math.max(arr[i], currentSum+arr[i]);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
// TC: O(n)
// SC: O(1)
    public static int maxSubarraySum_BETTER(int [] arr){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int currentSum=0;
            for(int j=i; j<arr.length; j++){
                currentSum+=arr[j];
                maxSum = Math.max(maxSum, currentSum);

            }
        }
        return maxSum;
    }

    public static int maxSubarraySum_BRUTEFORCE(int[] arr){
        int maxSum= Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                int currentSum=0;
                for(int k=i; k<=j; k++){
                    currentSum+=arr[k];
                }
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
