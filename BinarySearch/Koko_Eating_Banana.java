package BinarySearch;

public class Koko_Eating_Banana {
    public static void main(String[] args){
        int [] sample = {805306368,805306368,805306368};
        int givenHours = 1000000000;
        System.out.println(minEatingSpeed(sample, givenHours));
    }

    public static int minEatingSpeed(int [] piles, int givenH){
        int low = 1, high = Integer.MIN_VALUE;

        for(int n:piles){ high = Math.max(high, n);}

        while(low<=high) {
            int mid = low+(high-low)/2;
            if(calHours(piles, mid)<=givenH) high = mid-1;
            else low = mid+1;
        }
        return low;
    }

    public static long calHours(int[] arr, int hours){
        long totalHours = 0;
        for(long n:arr){
            totalHours += ((n+hours-1)/hours);
        }
        return totalHours;
    }
}
