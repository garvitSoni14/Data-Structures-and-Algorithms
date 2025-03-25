package Stack;

import java.util.Stack;

public class Sum_Of_Subarray_Minimums {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        int n = arr.length;

        int[] nextSm = nextSmaller(arr);
        int[] prevSm = prevSmaller(arr);

        long count = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prevSm[i];  // Distance from previous smaller element
            long right = nextSm[i] - i; // Distance from next smaller element
            long product = (left * right) % MOD;
            count = (count + (product * arr[i]) % MOD) % MOD;
        }

        return (int) count;
    }

    // Function to find Next Smaller Element (returns index)
    private int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n : stack.peek(); // If no smaller, set to n
            stack.push(i);
        }
        return ans;
    }

    // Function to find Previous Smaller Element (returns index)
    private int[] prevSmaller(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek(); // If no smaller, set to -1
            stack.push(i);
        }
        return ans;
    }
}
