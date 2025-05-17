package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ledtter_Combination_PhoneNumber
{
    public static Map<Character, String> getMap(){
        Map<Character, String> alphabets = new HashMap<>();
        alphabets.put('2',"abc"); alphabets.put('3',"def");alphabets.put('4',"ghi");alphabets.put('5',"jkl");alphabets.put('6',"mno");alphabets.put('7',"pqrs"); alphabets.put('8',"tuv");alphabets.put('9',"wxyz");return alphabets;    }

    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = getMap();
        List<String> ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        solve(0, digits, "", ans, map);
        return ans;
    }
    private static void solve(int i, String digits, String s, List<String> ans, Map<Character, String> map)
    {
        if(i==digits.length())
        {
            ans.add(s);
            return;
        }
        for(char c: map.get(digits.charAt(i)).toCharArray())
        {
            String temp = new String(s);
            temp+=c;
            solve(i+1, digits, temp, ans, map);
        }
    }
    public static void main(String [] args)
    {
        System.out.println(letterCombinations("23"));
    }
}
