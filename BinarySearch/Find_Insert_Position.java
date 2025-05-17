package BinarySearch;

public class Find_Insert_Position {
    public static void main(String [] args)
    {
        int [] sample = {1,2,4,4,7,8,9,9,10};
        int target = 3;
        System.out.println(searchInsert(sample , target));
    }


    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1, ans = nums.length;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[mid]>=target)
            {
                ans = mid;
                high = mid-1;}
            else low = mid+1;
        }
        return ans;
    }
}
