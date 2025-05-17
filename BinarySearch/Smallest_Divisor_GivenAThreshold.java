package BinarySearch;

public class Smallest_Divisor_GivenAThreshold {
    public static void main(String[] args){
        int[] sample = {1,2,5,9};
        System.out.println(smallestDivisor(sample, 6));
    }

    public static int smallestDivisor(int nums[], int threshold){
        int low=1, high=1;
        for(int i:nums){ high = Math.max(high, i); }
        int result=high;
        while(low<=high){
            int mid = (low+high)/2;
            if(sumByD(nums, mid)<=threshold){
                result = mid;
                high=mid+-1;
            }
            else low = mid+1;
        }
        return result;
    }
    public static int sumByD(int nums[], int mid){
        int sum =0;
        for(int n:nums){
            sum+=(n+mid-1)/mid;
        }
        return sum;
    }
}
