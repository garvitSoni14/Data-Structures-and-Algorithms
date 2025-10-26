// BRUTEFORCE: Try all possible triplets using 3 nested loops, and try to find the Minium (target-sum) and return that triplet. TC: O(n^3), SC: O(1).
// Optimal APPROACH: Sort the array, fix one element, and use two pointers (j, k) to find all unique triplets that sums closest to target.

package Array;

import java.util.Arrays;

public class Three_Sum_Closest {
    public static void main(String [] args){
        int[]nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest_BRUTEFORCE(int [] nums,int target){
        int closestSum = nums[0]+nums[1]+nums[2];
        for(int i=1;i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                for(int k = j+1; k<nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(Math.abs(sum-target)<Math.abs(closestSum-target)){
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length-2;i++){
            int j=i+1, k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target)<Math.abs(closest-target)){closest=sum;}
                if(sum>target)k--;
                else if(sum<target)j++;
                else return closest;
            }
        }
        return closest;
    }

    //TC: O(n log n + n^2) == O(n^2)
    //SC: O(1)
}
