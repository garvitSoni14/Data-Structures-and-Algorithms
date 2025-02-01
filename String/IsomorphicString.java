package String;

import java.util.HashMap;

public class IsomorphicString
{
    public static void main(String[] args)
    {
        String str1 = "esd";
        String str2 = "add";
        System.out.println(isomorphicString(str1,str2));
    }

    public static Boolean isomorphicString(String s1, String s2)
    {
        if(s1.length() != s2.length())
        {
            return false;
        }
        HashMap<Character,Character> mp1 = new HashMap<>();
        HashMap <Character,Boolean> mp2 = new HashMap<>();
        for(int i=0; i<s1.length();i++)
        {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(mp1.containsKey(ch1)==true)
            {
                if(mp1.get(ch1) != ch2)
                    return false;
            }
            else {
                mp1.put(ch1,ch2);
                mp2.put(ch1,true);
            }
        }
        return true;
    }
}
