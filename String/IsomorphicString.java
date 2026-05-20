package String;

import java.util.HashMap;
import java.util.HashSet;

public class IsomorphicString
{
    public static void main(String[] args)
    {
        String str1 = "epp";
        String str2 = "add";
        System.out.println(isomorphicString(str1,str2));
    }

    public static Boolean isomorphicString(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        HashMap<Character, Character> hm = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i<s1.length(); i++){
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if(hm.containsKey(c1)){
                if(hm.get(c1) != c2) return false;
            }
            else {
                if(hs.contains(c2)) return false;
                hm.put(c1,c2);
                hs.add(c2);
            }
        }
        return true;

    }
}
