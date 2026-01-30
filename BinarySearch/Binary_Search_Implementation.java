package BinarySearch;

public class Binary_Search_Implementation {
    public static void main(String [] args)
    {
        int [] sample = {1,2,3,4,5,6,7,8,9,10};
        int target = 8;
        System.out.println(binary_search(sample, target));
        System.out.println(recBinary(sample, 0,sample.length-1, target));

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

    public static int recBinary(int[] arr, int low, int high, int k){

        if(low>high) return -1;
        int mid = low + (high-low)/2;
        if(arr[mid]==k) return mid;
        else if(arr[mid]>k) return recBinary(arr,low, mid-1, k);
        else return recBinary(arr, mid+1, high, k);
    }
}
