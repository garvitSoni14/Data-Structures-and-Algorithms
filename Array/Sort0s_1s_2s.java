// BRUTE FORCE: General sorting. TC: O(n log n), SC: O(n).
// BETTER APPROACH:  Take three variables to store count of 0s, 1s,2s. for run three loops one after the othr and set values to 0, 1 and 2 in array. TC: O(2n), SC: O(1).
// OPTIMAL APPROACH: (VARIATION OF DUTCH NATIONAL FLAG ALGORITHM). Three pointer, low, mid, high. If mid==0 ->swap low with mid then increment both low and mid, if mid==1 ->
    // simply increment mid, if mid == 2 -> swap mid with high. that's how 0 to low-1 will contain0, low to mid-1 will contain 1 and mid to low-1 will contain unsorted, and
    // low to n-1 will contain 2.

package Array;

import java.util.Arrays;

public class Sort0s_1s_2s {
    public static void main(String[] args){
        int[] sample = {0,1,0,2,0,0,1,2,2,1};
        sort0s_1s_2s(sample);
        System.out.println(Arrays.toString(sample));
    }

//    public static void sort0s_1s_2s(int []arr){
//        int low=0, mid=0, high= arr.length-1;
//        while(mid<=high){
//            if(arr[mid] ==0) {
//                int temp = arr[low];
//                arr[low] =arr[mid];
//                arr[mid] = temp;
//                low++;
//                mid++;
//            }
//            else if(arr[mid]==1){
//                mid++;
//            }
//            else {
//                int temp =arr[mid];
//                arr[mid] =arr[high];
//                arr[high] = temp;
//                high--;
//            }
//        }
//    }

    public static void sort0s_1s_2s(int []arr){
        int low=0, mid=0, high= arr.length-1;
        while(mid<=high){
            if(arr[mid] ==0) {
                int temp = arr[low];
                arr[low] =arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else {
                int temp =arr[mid];
                arr[mid] =arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }





    public static void sort0s_1s_2s_BETTERAPPROACG(int [] arr){
        int count0=0, count1=0, count2=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0) count0++;
            else if (arr[i]==1) count1++;
            else count2++;
        }
        for(int k=0; k<count0; k++) arr[k]=0;
        for(int k=count0; k<count0+count1; k++) arr[k] =1;
        for(int k=count0+count1; k<count0+count1+count2; k++) arr[k] =2;

    }
}
