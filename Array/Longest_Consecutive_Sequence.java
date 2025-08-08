// BRUTEFORCE: For each element of the array, try to find its consecutive greater ones and count the maximum consecutive ones of that element. Then return the greatest consecutive count. TC: O(n^2), SC: O(1).
// BETTER APPROACH: Sort the array and find the longest sequence. TC: O(n + n log n), SC: O(1).
// OPTIMAL APPROACH: Store all elements in HashSet. For every element with no smaller element, find consecutive greater element's count. return the longest consecutive count.
package Array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Longest_Consecutive_Sequence {

    public static void main(String [] args){
        int [] sample= {102,4,100,1,101,3,2,1,1};
        System.out.println(longestSequence(sample));
    }

    public static int longestSequence_BRUTEFORCE(int [] arr){
        int longest = 1;
        for(int i = 0; i<arr.length; i++){
            int x = arr[i];
            int count = 1;
            while(linearSearch(arr,x+1) == true){
                x+=1;
                count+=1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
    public static boolean linearSearch(int arr[], int k)
    {   for(int i = 0;i<arr.length; i++) {   if(arr[i] == k) return true;    }
        return false;
    }

    public static int longestSequence_BETTER(int [] arr){
        if(arr.length == 0) return 0;
        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int longest = 1;
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]-1 ==lastSmaller){
                count+=1;
                lastSmaller = arr[i];
            }
            else if(arr[i]!=lastSmaller){
                count = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    public static int longestSequence(int [] arr){
        if(arr.length == 0) return 0;
        int longest = 1;
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        for(int i:set){
            if(! set.contains(i-1)){
                int count = 1;
                int x = i;
                while(set.contains(x+1)){
                    x +=1;
                    count+=1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

// TC: O(n + 2n)
// SC: O(n)
}
