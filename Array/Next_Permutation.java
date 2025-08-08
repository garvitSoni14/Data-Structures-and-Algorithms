//BRUTEFORCE: Generate all permutations using recursion. Sort them in lexicographical order. Find the current array's poition in that list. return the right next permutation (or the first if it's the last one). TC: O(n!), SC: O( n * n!).
// OPTIMAL APPROACH: Find the first BreakPoint element from the right, swap it with the next greater element to its right, then reverse the suffix.

package Array;

import java.util.*;

public class Next_Permutation {
    public static List<Integer> nextGreaterPermutation(List<Integer> A) {
        int n = A.size();
        int ind = -1;

        // Step 1: Find the break point
        for (int i = n - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                ind = i;
                break;
            }
        }

        // Step 2: If no break point, reverse and return
        if (ind == -1) {
            Collections.reverse(A);
            return A;
        }

        // Step 3: Swap with next greater element on right
        for (int i = n - 1; i > ind; i--) {
            if (A.get(i) > A.get(ind)) {
                Collections.swap(A, i, ind);
                break;
            }
        }

        // Step 4: Reverse the suffix
        Collections.reverse(A.subList(ind + 1, n));

        return A;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("Next Permutation: " + nextGreaterPermutation(arr));
    }
}
