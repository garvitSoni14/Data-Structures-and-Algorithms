// BRUTEFORCE: Compare every pair (i, j) with i < j and increment count whenever arr[i] > 2*arr[j]. TC: O(n²), SC: O(1)
// OPTIMAL APPROACH: Recursively divide the array into halves, count valid pairs during merge stepby moving right pointer until arr[i] > 2*arr[right], then merge sorted halves.
    // TC: O(n log n), SC: O(n)

package Array;

import java.util.ArrayList;

public class Reverse_Pairs {
    public static void main(String[] args){
//        int [] arr = {40,25,19,12,9,6,2};
        int [] arr = {1,3,2,3,1};
        System.out.println(team(arr, arr.length));
    }

    public static void merge(int [] arr, int low, int mid, int high){
        ArrayList<Integer>temp = new ArrayList<>();
        int left=low;
        int right = mid+1;
        while(left <=mid && right <=high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
            while(left<=mid){
                temp.add(arr[left]);
                left++;
            }
            while(right<=high){
                temp.add(arr[right]);
                right++;
            }
            for(int i=low; i<=high; i++){
                arr[i] = temp.get(i-low);
            }
        }
    }
    public static int countPairs(int[] arr, int low, int mid, int high){
        int right = mid+1;
        int count = 0;
        for(int i=low; i<=mid; i++){
            while(right <=high && arr[i] > 2 * arr[right]) right++;
            count +=(right-(mid+1));

        }
        return count;
    }
    public static int mergeSort(int [] arr, int low, int high){
        int count=0;
        if(low>=high) return count;
        int mid= (low+high)/2;
        count+=mergeSort(arr, low, mid);
        count+=mergeSort(arr, mid+1, high);
        count +=countPairs(arr,low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }
    public static int team(int[] skill, int n){
        return mergeSort(skill, 0, n-1);
    }
    public static int reversePairs_BRUTEFORCE(int [] arr){
        int count=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j< arr.length; j++){
                if(arr[i] > (2*arr[j])){
                    count++;
                }
            }
        }
        return count;
    }
}
