// BRUTEFORCE: For each number 1..n, count frequency by scanning array; the one with count=2 is repeating, and count=0 is missing. TC: O(n²), SC: O(1)
// BETTER: Use a frequency array or HashSet to track counts; find repeating (freq=2) and missing (freq=0). TC: O(n), SC: O(n)
// OPTIMAL: Use mathematical equations (sum and sum of squares) to derive repeating (x) and missing (y) by solving equations: s - Sn = x - y  and  s2 - S2n = x² - y² = (x-y)(x+y)

package Array;

import java.util.Arrays;

public class Find_Missing_And_Repeating {
    public static void main(String [] args){
        int [] sample = {1,2,3,4,5,5,6,7};
        System.out.println(Arrays.toString(findMissingRepeating(sample)));
    }

    public static int[] findMissingRepeating(int []nums){
        long n = nums.length;
        long Sn = (n*(n+1))/2;
        long S2n = (n*(n+1)*(2*n+1))/6;
        long s=0, s2=0;
        for(int i=0;i<n; i++){
            s += (long)nums[i];
            s2 += (long) (nums[i]*nums[i]);
        }
        long val1 = s-Sn;
        long val2 = s2-S2n;
        val2 = val2/val1;
        long x = (val1 + val2)/2;
        long y = x - val1;
        return new int[]{(int)x,(int)y};
    }
    // TC: O(n)
    // SC: O(1)
}
