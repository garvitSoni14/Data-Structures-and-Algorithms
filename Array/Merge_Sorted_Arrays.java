// OPTIMAL APPROACH: Swap larger elements from end of first array with smaller from start of second, then sort both arrays.
        // **** this is the only approach if we want to not use any extra space....****
package Array;

import java.util.Arrays;

public class Merge_Sorted_Arrays {
    public static void main(String [] args){
        int [] nums1 = {1,4,8,10};
        int [] nums2 = {2,3,9};
        merged(nums1, nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

    public static void merged(int nums1[], int nums2[]){
        int left=nums1.length-1;     //last index of nums1
        int right = 0;               // first index of nums2
        while(left>=0 && right<nums2.length){
            if(nums1[left]>nums2[right]){
                swap(nums1,left,nums2,right);
                left--;
                right++;
            }
            else{break;}
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
//TC: O((n+m) log n + (n+m) log m)
// SC: O(1).

    public static void swap(int nums1[], int left, int nums2[], int right){
        int temp = nums1[left];
        nums1[left] = nums2[right];
        nums2[right] = temp;
    }
}
