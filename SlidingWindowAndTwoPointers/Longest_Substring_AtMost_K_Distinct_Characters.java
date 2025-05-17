package SlidingWindowAndTwoPointers;

import java.util.HashMap;

public class Longest_Substring_AtMost_K_Distinct_Characters {
    public static void main(String[] args)
    {
        String sample = "eceba";
        int j = 2;
        System.out.println(longest_substring(sample,j));
    }

    public static int longest_substring(String s, int k)
    {
        int left=0, right=0, maxlen=0;
        HashMap<Character, Integer> map =new HashMap<>();
        while(right<s.length())
        {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k)
            {
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0) { map.remove(s.charAt(left)); }
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
}
