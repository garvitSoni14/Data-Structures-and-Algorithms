// BRUTE FORCE: Generate all possible sub-arrays, and return the subarray(j-i+1) whose sum==k and length is MaximumTC: O(n^3), SC: O(1)
// BETTER BRUTE FORCE: Generate all possible subarrays fron i=0(j=i)...and if currentSum==k, return max len with currentSum==k. TC: O(n^2), SC: O(1)
// OPTIMAL APPROACH: Store all prefix sums from 0 to n in HashMao, if current prefixSum==k, maxlength=i+1, if current prefixSum>k, find prevIndex of (prefixSum-k) in map, and put max of (maxLength , i-prevIndex)and return it.
package Array;

import java.util.HashMap;
import java.util.Map;

public class Max_SubArray_KSumPandN
{
    public static void main(String[] args)

    {
        int[] arr = {1,2,0,-1,1,1,2,1,3,4,-1,-1};
        int k = 3;
        System.out.println("The maximum length of the subarray with given sum is : "+kSumSubarray(arr,k));
    }

    public static int kSumSubarray(int arr[],int k)
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int prefixSum=0, maxlength=0;
        for(int i=0; i<arr.length; i++){
            prefixSum+=arr[i];

            if(prefixSum==k){
                maxlength = i+1;
            }
            if(mp.containsKey(prefixSum-k)){
                int prevIndex = mp.get(prefixSum-k);
                maxlength = Math.max(maxlength, i-prevIndex);
            }
            if( !mp.containsKey(prefixSum)){
                mp.put(prefixSum,i);
            }
        }
        return maxlength;
    }
}

// TC: O(n)
// SC: O(n)
