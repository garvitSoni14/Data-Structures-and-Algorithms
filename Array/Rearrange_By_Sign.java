// BRUTEFORCE: Segregate positives and negatives in 2 different arrays, then take a new array and alternatively store positive and negative elements in the array, + -> 2(i)th position, - -> 2(i+1)th position. TC: O(2n), SC: O(2n).
// BETTER APPROACH: Use a result aray and every time a + element comes, place it at even position and - element at odd positions. TC: O(n), SC: O(n).
// OPTIMAL APPROACH: i=0, j=1, if i place found to be negative or j found to be positive , just swap them.
package Array;

import java.util.Arrays;

public class Rearrange_By_Sign {

    public static void main(String [] args){
        int [] sample = {1,2,-4,-5};
        System.out.println(Arrays.toString(seggregatePN(sample)));
    }

    public static int [] seggregatePN(int [] arr){
        int i=0, j=1, n = arr.length;
        while(i<n && j<n){
            while(i<n && arr[i]>=0) i+=2;
            while(j<n && arr[j]<0) j+=2;
            if(i<n && j<n){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
        }
        return arr;
    }

// TC: O(n)
// SC: O(1)s

    public static int [] seggregatePN_BETTERAPPROACH(int [] arr){
        int posIndex = 0, negIndex = 1;
        int [] result =new int [arr.length];
        for(int i=0; i< arr.length; i++){
            if(arr[i]>=0){
                result[posIndex] = arr[i];
                posIndex+=2;
            }
            else{
                result[negIndex] = arr[i];
                negIndex+=2;
            }
        }
        return result;
    }

    public static int[] seggregatePN_BRUTEFORCE(int[] arr){
        int [] pos = new int[arr.length/2];
        int [] neg = new int[arr.length/2];
        int [] result = new int[arr.length];
        int i=0, p=0,n=0;
        while(i<arr.length){
            if(arr[i]>0){
                pos[p++] =arr[i++];
            }
            else{
                neg[n++] = arr[i++];
            }
        }
        for(int j=0; j<arr.length/2; j++){
            result[2*j] = pos[j];
            result[(2*j)+1] = neg[j];
        }
        return result;
    }
}
