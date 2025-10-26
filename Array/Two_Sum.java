// BRUTE FORCE: Run a loop on array to select an element, inside it, run another loop on the remaining array to find a number with whom, the sum is equal to desired number, return. TC O(n^2), SC: O(1).
//BETTER APPROACH:Create a HashMap, run a loop on the array, check if Hashmap contains target-arr[i], if contains, return i,key then store arr[i] into the HashMap. TC: O(n), SC: O(n).
// OPTIMAL APPROACH: SOrt the array,  use two pointers i and j, keep i at first index and j at last index, if i+j>target -> j-- , elseif i+j<target -> i++, if i-j ==target -> return new int[]{i,j}.
package Array;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum {

    public static void main(String[] args){
        int [] sample = {13,2,45,11,23,1,4,6};
        int target = 12;
        System.out.println(Arrays.toString(twoSum_BETTER(sample, target)));
    }

    public static int[] twoSum(int[] arr, int k){
        Arrays.sort(arr);
        int i=0, j=arr.length-1;
        while(i<=j){
            if(arr[i] + arr[j] > k) j--;
            else if (arr[i] + arr[j]<k) i++;
            else if (arr[i]+arr[j] == k) return new int[] {i,j};
        }
        return new int[] {};
    }
// TC: O(n log n)
// SC: O(1)

    public static int[] twoSum_BETTER(int[] arr, int k){
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for(int i=0; i<=arr.length-1; i++){
            int remaining = k-arr[i];
            if(mpp.containsKey(remaining)){
                return new int[] {i,mpp.get(remaining)};
            }
            mpp.put(arr[i],i);
        }
        return new int[] {};
    }
    public static int[] twoSum_BRUTEFORCE(int[] arr, int k){
        for(int i=0; i<=arr.length-1; i++){
            int remaining = k-arr[i];
            for(int j=i+1; j<= arr.length-1; j++){
                if(arr[j] == remaining){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }
}
