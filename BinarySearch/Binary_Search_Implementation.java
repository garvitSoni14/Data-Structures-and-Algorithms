package BinarySearch;

public class Binary_Search_Implementation {
    public static void main(String [] args)
    {
        int [] sample = {1,2,3,4,5,6,7,8,9,10};
        int target = 8;
        System.out.println(binary_search(sample, target));
        System.out.println(binary(sample, 0,sample.length-1, target));

    }
    public static int binary_search(int[] nums, int target)
    {
        int low = 0, high = nums.length-1;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) low = mid+1;
            else high =mid-1;
        }
        return -1;
    }

    public static int binary(int[] nums, int low, int high, int target)
    {
        if(low>high) return -1;
        int mid = (low+high)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target) return binary(nums, low, mid-1,target);
        else return binary(nums, mid+1, high, target);
    }
}
