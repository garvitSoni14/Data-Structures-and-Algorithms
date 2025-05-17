package Stack;

import java.util.Arrays;
import java.util.Stack;

public class Number_Of_NGEs {
    public static void main(String[] args) {
        int[] queryIndices = {1, 4, 2};
        int[] arr2 = {1, 2, 3, 4, 44, 5, 666, 77778, 88888};
        System.out.println(Arrays.toString(amountOfNGEs(queryIndices, arr2)));
    }

    public static int[] amountOfNGEs(int[] indices, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] map = new int[arr.length];                        // To store the count of NGEs for each index
        int[] result = new int[indices.length];                 // To store the result for the specified indices

        for (int i = arr.length - 1; i >= 0; i--)                   // Traverse the array from right to left
        {
            while (!stack.isEmpty() && stack.peek() <= arr[i])         // Pop elements from the stack that are less than or equal to the current element

            {
                stack.pop();
            }
            // The size of the stack is the number of elements strictly greater than arr[i] to its right
            map[i] = stack.size();
            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        // Extract the counts for the specified indices
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] >= 0 && indices[i] < arr.length) {
                result[i] = map[indices[i]];
            } else {
                result[i] = 0; // Handle invalid indices (if any)
            }
        }

        return result;
    }
}