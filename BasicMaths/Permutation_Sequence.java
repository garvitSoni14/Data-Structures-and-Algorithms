// LEETCODE: 60
//TC: O(n), SC: O(n^2)
// SC: O(n)

package BasicMaths;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence {
    public static void main(String [] args){
        System.out.println(getPermutation(4,9));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int [] fact = new int [n];
        for(int i = 1; i<=n;i++) nums.add(i);
        fact[0]=1;
        for(int i = 1;i<n; i++) fact[i]=fact[i-1]*i;
        k--;
        StringBuilder res = new StringBuilder();
        for(int i=n; i>=1;i--){
            int idx=k/fact[i-1];
            res.append(nums.get(idx));
            nums.remove(idx);
            k %=fact[i-1];
        }
        return res.toString();

    }
}
