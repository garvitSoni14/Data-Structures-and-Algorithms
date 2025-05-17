package SlidingWindowAndTwoPointers;

public class Longest_Repeating_Character_Replacement {

    public static void main(String[] args)
    {
        String sample = "AABABBA";
        int k=1;
        System.out.println(longest_repeating_substring(sample,k));
    }

    public static int longest_repeating_substring(String s, int k)
    {
        int right=0, left=0, maxlen=0, maxfreq=0;
        int [] arr = new int[26];
        while(right < s.length())
        {
            arr[s.charAt(right)-'A']++;
            maxfreq= Math.max(maxfreq, arr[s.charAt(right)-'A']);

            while( (right-left+1 ) - maxfreq > k )
            {
                arr[s.charAt(left)-'A']--;
                left++;
            }
            maxlen = Math.max(maxlen, right-left+1);
            right++;
        }
        return maxlen;
    }
}
