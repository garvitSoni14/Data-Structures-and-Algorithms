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
        int currentSum = arr[0];
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
}
