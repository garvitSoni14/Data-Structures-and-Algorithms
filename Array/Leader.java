// BRUTFORCE: For each element, check if it is greater than all elements to its right, if so, add it to result arraylist. TC: O(n^2). SC: O(n).
// OPTIMAL APPROACH: Traverse from the right to left of array, keep track of max element till now so far, collect elements greater than it in result arraylist.
package Array;

import java.util.*;

public class Leader {

    public static void main(String args[]) {

        int [] sample = {10, 22, 12, 3, 0, 6};

        System.out.println(leader(sample));

    }

    public static ArrayList<Integer> leader(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        int maxTillNow=Integer.MIN_VALUE;
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]>maxTillNow){

                result.add(arr[i]);
                maxTillNow = arr[i];
            }
        }
        Collections.reverse(result);  // because we are storing leaders in result in reverse order of their apprearance.
        return result;
    }
// TC: O(n)
// SC: O(n)

    public static ArrayList<Integer> leader_BRUTEFORCE(int [] arr){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            boolean flag=true;
            for(int j=i+1; j< arr.length; j++){
                if(arr[j]>arr[i]) flag = false;

            }
            if(flag==true) result.add(arr[i]);
        }
        return result;
    }
}
