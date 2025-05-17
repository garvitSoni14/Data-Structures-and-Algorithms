package BinarySearch;

public class Capacity_To_Ship_Packages {

    public static void main(String [] args){
        int [] sample  = {1,2,3,4,5,6,7,8,9,10};
        int days= 5;
        System.out.println(shipWithinDays(sample, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0, minDays = 0;
        for(int i =0;i<weights.length;i++){
            high += weights[i];
            low =Math.max(low, weights[i]);
        }
        while(low<=high){
            int mid = (low+high)/2;
            minDays = findDays(weights, mid);
            if(minDays<=days) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    public static int findDays(int [] weights, int capacity){
        int load = 0 , days = 1;
        for(int i=0; i<weights.length;i++){
            if(load + weights[i]>capacity){
                days+=1;
                load = weights[i];
            }
            else load+=weights[i];
        }
        return days;
    }
}
