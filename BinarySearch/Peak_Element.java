package BinarySearch;

public class Peak_Element {
    public static void main(String [] args)
    {
        int [] sample = {0,1,2,3,2,1,4,5,6,7,6,5,8,9,0,1,1};
        System.out.println(sample[findPeakElement(sample)]);
    }

    public static int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        int low = 1, high = nums.length-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]>nums[mid-1]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
