package SlidingWindowAndTwoPointers;

public class Substring_Containing_All3_Characters {

    public static void main(String [] args)
    {
        String sample = "abcabc";
        System.out.println(numberOfSubstrings(sample));
    }

    public static int numberOfSubstrings(String s) {
        int [] lastSeen = {-1,-1,-1};
        int count=0;
        for(int i=0;i<s.length();i++)
        {lastSeen[s.charAt(i)-'a'] = i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1) count+= 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
        }return count;}
}
