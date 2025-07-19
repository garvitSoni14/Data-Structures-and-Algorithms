// BRUTE FORCE: Generate all possible sub-arrays, and return the subarray(j-i+1) whose sum==k and length is MaximumTC: O(n^3), SC: O(1)
// BETTER APPROACH: PresumMap. TC: O(n log n), SC: O(n).
// OPTIMAL APPROACH: Use two pointers i and j, store the sum till j in currentSum, if currentSum==k , find max of result and (j-i+1) return result, if currentSum>k and i<j , subtractarr[i] till currentSum<=k.
package Array;

public class Longest_Subarray_KSum
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,8,4,1,2,7,9};
        int k = 15;
        System.out.println("Longest Subarray size to give sum "+k+ " : "+longestSubarrayWithKSum(arr,k));
    }

    public static int longestSubarrayWithKSum(int arr[],int k)
    {
        int currentSum = 0;
        int result = 0;
        int i = 0;
        int j = 0;
        int count=0;
        while (j<arr.length)
        {
           currentSum+=arr[j];

           while(i<j && currentSum>k)
           {
               currentSum-=arr[i];
               i++;
           }
           if(currentSum == k)
           {
               result = Math.max(j-i+1, result);
           }
           j++;
        }
        return result;
    }


    public static int BRUTE_FORCE(int []arr, int k){
        int result=0;
        for (int i=0; i<=arr.length-1; i++)
        {
            for(int j=i; j<=arr.length-1; j++)
            {
                int currentSum=0;
                for(int h = i; h<=j; h++){
                    currentSum+=arr[h];
                }
                if(currentSum==k){
                    result = Math.max(result, j-i+1);
                }
            }
        }
        return result;
    }
}

// TC: O(n)   , WorstCase TC: O(2n) because the j pointer moves form 0 to n for once, inside it, i can also move from 0 to n when needed.
// SC: O(1)
