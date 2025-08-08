//Optimal Approach: Use a HashMap and store all the prefix sums in it, while storing, for every occurence of prefixSum-k add prefixSum-k 's frequency to count.
package Array;

import java.util.HashMap;

public class Count_Subarray_SumK {
    public static void main(String [] args){
        int arr[] = {1,2,3,-3,1,1,1,4,2,-3};
        int k=3;
        System.out.println(subarraySumK(arr, k));
    }

    public static int subarraySumK(int[] nums, int k) {
        int prefixSum=0, count=0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i:nums){
            prefixSum+=i;
            if(mp.containsKey(prefixSum-k)){
                count+=mp.get(prefixSum-k);
            }
            mp.put(prefixSum, mp.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
// TC: O(n)
// SC: O(n)
