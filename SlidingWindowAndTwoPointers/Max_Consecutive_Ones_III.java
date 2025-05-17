package SlidingWindowAndTwoPointers;

public class Max_Consecutive_Ones_III
{
    public static void main(String [] args)
    {
        int[] arr = {1,1,1,0,0,1,1,1,1,1,0};
        int k=2;
        System.out.println(max_consecutive_one(arr,k));
    }

    public static int max_consecutive_one(int[] arr, int k)
    {
        int left=0, right=0, zeroes = 0, maxlen=0;
        while(right<arr.length)
        {
            if(arr[right]==0) zeroes++;
            while(zeroes>k)
            {
                if(arr[left]==0) zeroes--;
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
}
