package Array;

import java.util.HashMap;
import java.util.Map;

public class Max_SubArray_KSumPandN
{
    public static void main(String[] args)

    {
        int[] arr = {1,2,0,-1,1,1,2,1,3,4,-1,-1};
        int k = 3;
        System.out.println("The maximum length of the subarray with given sum is : "+kSumSubarray(arr,k));
    }

    public static int kSumSubarray(int arr[],int k)
    {
        int sum=0,maxlen=0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
            sum +=arr[i];
            if(sum==k)
            {
                maxlen = Math.max(maxlen, i+1);
            }
            int rem = sum-k;
            if(prefixSumMap.containsKey(rem))
            {
                int len = i-prefixSumMap.get(rem);
                maxlen = Math.max(maxlen, len);
            }
            if(!prefixSumMap.containsKey(sum))
            {
                prefixSumMap.put(sum,i);
            }
        }
    return maxlen;
    }
}
