// BRUTEFORCE: For each element of the array, traverse whole array to count its occurence and if the count > n/2, return the element. TC: O(n^2), SC: O(1).
// BETTER APPROACH:  Store the frequency of every unique element in a HashMap and return the element with frequency > n/2. TC: O(n), SC:O(n).
// OPTIMAL APPROACH: (MOORE's VOTING ALGORITHM): Traverse whole array and get the element which is occuring very frequently, Traverse again toget the count of that frequently occuring element. Now if count > n/2, return element else -1.
package Array;

import java.util.HashMap;

public class Majority_Nby2 {
    public static void main(String[] args){
        int [] sample = {3,2,3,3};
        System.out.println(majority(sample));
    }

    // Moore's voting algorithm........
    public static int majority(int [] arr){
        int count=0, element=0;
        for(int i=0; i< arr.length; i++){
            if(count==0){
                count=1; element=arr[i];
            }
            else if(arr[i] == element) count++;
            else count--;
        }
        int count1=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == element) count1++;
        }
        if(count1 > arr.length/2) return element;
        return -1;
    }
// TC: O(n)
// SC: O(1)

    public static int majority_BETTER(int [] arr){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<=arr.length-1; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
            if (mp.get(arr[i]) > arr.length / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int majority_BRUTEFORCE(int [] arr){
        for(int i=0; i<=arr.length-1; i++){
            int count=0;
            for(int j = 0; j<=arr.length-1; j++){
                if(arr[j] ==arr[i]) {count++;}
            }
            if(count > arr.length/2) {return arr[i];}
        }
        return -1;
    }
}
