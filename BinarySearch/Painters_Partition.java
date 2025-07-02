package BinarySearch;

public class Painters_Partition {
    public static void main(String[] args){
        int [] sample = {10,20,30,40};
        int k=2;
        System.out.println(minimizedMaximumSubarraySum(sample,k));
    }

    public static int minimizedMaximumSubarraySum(int [] nums, int k){
        int low = Integer.MIN_VALUE, high =0;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low, nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid = (low+high)/2;
            int partitions = countPartition(nums, mid);
            if(partitions>k){
                low = mid+1;
            }
            else high = mid-1;
        }
        return low;
    }
    public static int countPartition(int [] nums, int maxSum){
        int partition = 1,subarraySum=0;
        for(int i=0;i<nums.length;i++){
            if(subarraySum+nums[i]<=maxSum){
                subarraySum+=nums[i];
            }
            else {
                partition++;
                subarraySum = nums[i];
            }
        }
        return partition;
    }
}
