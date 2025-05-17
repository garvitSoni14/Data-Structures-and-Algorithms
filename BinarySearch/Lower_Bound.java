package BinarySearch;

public class Lower_Bound {
    public static void main(String [] args)
    {
        int [] sample = {1,2,4,4,7,8,9,9,10};
        int target = 3;
        System.out.println(lower_bound(sample , target));
    }

    public static int lower_bound(int [] nums, int target)
    {
        int low = 0, high = nums.length-1, ans = nums[nums.length-1];
        while(low<high)
        {
            int mid = (low+high)/2;
            if(nums[mid]>=target)
            {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }


    public static int upper_bound(int [] nums, int target)
    {
        int low = 0, high = nums.length-1, ans = nums[nums.length-1];
        while(low<high)
        {
            int mid = (low+high)/2;
            if(nums[mid]>target)
            {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
}
