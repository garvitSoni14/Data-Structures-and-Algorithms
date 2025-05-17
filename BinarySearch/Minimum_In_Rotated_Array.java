package BinarySearch;

public class Minimum_In_Rotated_Array {
    public static void main(String [] args)
    {
        int[] sample = {4,5,6,7,1,2,3};

        System.out.println(findMin(sample));
        System.out.println(Rotated(sample));
    }

    public static int findMin(int[] nums) {
        int low = 0, high = nums.length-1, ans  = Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid])
            {
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }


    public static int Rotated(int[] nums) {
        int low = 0, high = nums.length-1, ans  = Integer.MAX_VALUE;
        int index = 0;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid])
            {
                if(nums[low]<ans)
                {
                    ans  = nums[low];
                    index = low;
                }

                low = mid+1;
            }
            else {
                if(nums[mid]<ans)
                {
                    ans  = nums[mid];
                    index = mid;
                }
                high = mid-1;
            }
        }
        return index;
    }
}
