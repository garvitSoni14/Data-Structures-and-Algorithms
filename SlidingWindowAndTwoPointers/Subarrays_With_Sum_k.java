package SlidingWindowAndTwoPointers;

public class Subarrays_With_Sum_k {

    public static void main(String[] args)
    {
        int [] arr = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(arr, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal)
    {
        return x(nums, goal) - x(nums,goal-1);
    }


    public static int x(int[] nums, int goal)
    {
        if(goal<0) return 0;
        int right=0, left=0, subarrays=0, sum=0;
        while(right < nums.length)
        {
            sum+=nums[right];
            while(sum > goal)
            {
                sum-=nums[left];
                left++;
            }
            subarrays+=(right-left+1);
            right++;
        }
        return subarrays;
    }
}
