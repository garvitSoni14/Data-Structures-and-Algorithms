package BinarySearch;

public class Sorted_Rotated_Array_II {
    public static void main (String [] args)
    {
        int[] sample = {3,1,2,3,3,3,3};
        int target = 1;
        System.out.println(search(sample, target));
    }
    public static boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[mid]==target) return true;
            if(nums[low]==nums[mid] && nums[mid]==nums[high])
            {
                low++;
                high--;
            }
            else if (nums[low]<=nums[mid])
            {
                if(nums[low]<=target&& target<=nums[mid]) high = mid-1;
                else low = mid+1;
            }
            else
            {
                if(nums[mid]<=target && target<=nums[high]) low = mid+1;
                else high = mid-1;
            }
        }
        return false;

    }
}

