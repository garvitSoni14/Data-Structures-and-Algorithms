// BRUTE FORCE: Sort intervals by start, then iterate once, adding a new interval if it doesn't overlap the last in result, otherwise merge by updating the last interval's end to the max end. TC: O(n^2), SC: O(n).
// OPTIMAL APPROACH: Sort intervals by start, skip if fully contained in previous merged, else extend end by scanning forward until no overlap, then add merged interval to result.
package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Overlapping_Subintervals {

    public static void main (String [] args){
        int arr[][] = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println(mergeSubintervals(arr));
    }

    public static List<List<Integer>> mergeSubintervals_BRUTEFORCE(int arr[][]){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
           if(result.isEmpty() || arr[i][0]>result.get(result.size()-1).get(1)){
               result.add(Arrays.asList(arr[i][0], arr[i][1]));
           }
           else{
               result.get(result.size()-1).set(1, Math.max(result.get(result.size()-1).get(1), arr[i][1]));
           }
        }
        return result;
    }
// TC: O(n log n)
// SC: O(n)

    public static List<List<Integer>> mergeSubintervals(int arr[][]){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            int start = arr[i][0];
            int end= arr[i][1];
            if(!result.isEmpty() && end <=result.get(result.size()-1).get(1)){
                continue;
            }
            for(int j=i+1; j<arr.length; j++){
                if(arr[j][0] <= end){
                    end = Math.max(end, arr[j][1]);
                }
                else break;
            }
            result.add(Arrays.asList(start, end));
        }
        return result;
    }
}
