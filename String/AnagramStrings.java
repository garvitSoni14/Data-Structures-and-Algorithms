package String;

import java.util.HashMap;
import java.util.Map;

public class AnagramStrings
{
    public static void main(String[] args)
    {
        String str1 = "tyytt";
        String str2 = "ttyyt";
        System.out.println(anagramStrings(str1,str2));
    }

    public static Boolean anagramStrings(String s1, String s2)
    {
        if(s1.length() != s2.length())
        {
            return false;
        }
        Map<Character,Integer> freq = new HashMap<>();
        for(char c:s1.toCharArray())
        {
            freq.put(c,freq.getOrDefault(c,0)+1);
        }

        for(char c:s2.toCharArray())
        {
            if(!freq.containsKey(c))
            {
                freq.put(c,freq.get(c)-1);
            }
        }
        for(int i : freq.values())
        {
            if(i != 0)
            {
                return false;
            }
        }
        return true;
    }
}
