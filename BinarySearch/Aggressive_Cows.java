package BinarySearch;

import java.util.Arrays;

public class Aggressive_Cows {

    public static void main(String[]args){
        int [] sample = {0,3,4,7,10,9};
        int k = 4;
        System.out.println(aggressiveCows(sample, k));
    }

    public static int aggressiveCows(int [] nums, int k){
        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length-1] - nums[0];
        while(low<=high){
            int mid=(low+high)/2;
            if(canWePlace(nums, mid, k) ==true){
                low = mid+1;
            }
            else high = mid-1;
        }
        return high;
    }

    public static boolean canWePlace(int [] nums, int dist, int cows){
        int countCows=1, lastPlaced = nums[0];
        for(int i=0; i<nums.length; i++){
            if(nums[i]-lastPlaced>=dist){
                countCows++;
                lastPlaced = nums[i];
            }
            if(countCows>=cows) return true;
        }
        return false;
    }
}
