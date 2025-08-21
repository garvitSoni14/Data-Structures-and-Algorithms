package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Chocolate_Distribution_Problem {

    public static void main(String [] args){
        ArrayList<Integer> sample = new ArrayList<>(Arrays.asList(3, 4, 1, 9, 56, 7, 9, 1));
        int m = 5;
        System.out.println(findMinDiff(sample, m));
    }
    public static int findMinDiff(ArrayList<Integer> arr, int m) {
        Collections.sort(arr);
        int i=0, j = m-1;
        int mini = Integer.MAX_VALUE;
        while(j<arr.size()){
            int diff = arr.get(j)-arr.get(i);
            mini = Math.min(mini, diff);
            i++;
            j++;
        }
        return mini;
    }
    // TC: O(n log n) .....collections.sort== O(n log n) + sliding window: O(n-j) ~ O(n)...
    // SC: O(n) ...... only timesort algo (used in list.sort(null) by Collections.sort takes O(n)....

}

