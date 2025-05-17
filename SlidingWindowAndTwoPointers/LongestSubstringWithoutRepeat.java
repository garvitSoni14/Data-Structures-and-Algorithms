package SlidingWindowAndTwoPointers;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {

    public static void main(String [] args)
    {
        String sample ="cadbrabcd";
        System.out.println(longest_substring_without_repeat(sample));
    }

    public static int longest_substring_without_repeat(String s)
    {
        int left = 0, right = 0, maxlength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right<s.length())
        {
            if(map.containsKey(s.charAt(right))) left = Math.max(left, map.get(s.charAt(right))+1);
            map.put(s.charAt(right),right);
            maxlength = Math.max(maxlength, right-left+1);
            right++;
        }
        return maxlength;
    }
}
