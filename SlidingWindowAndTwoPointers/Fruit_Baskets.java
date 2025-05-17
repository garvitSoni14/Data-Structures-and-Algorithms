package SlidingWindowAndTwoPointers;

import java.util.HashMap;

public class Fruit_Baskets
{
    public static void main(String [] args)
    {
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(fruit_basket(arr));
    }

    public static int fruit_basket(int[] arr)
    {
        int left=0, right=0, maxlen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(right<arr.length)
        {
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            while(map.size()>2)
            {   map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left])==0) map.remove(arr[left]);
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
}
