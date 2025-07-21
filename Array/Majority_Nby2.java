package Array;

import java.util.HashMap;

public class Majority_Nby2 {
    public static void main(String[] args){
        int [] sample = {3,2,3,3};
        System.out.println(majority(sample));
    }

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
