// BRUTE_FORCE: Pick first string of array as prefix, compare it with every other strings of the array, reduce the string by one on every mismatch. TC: O(n * m), SC: O(1)
// BETTER_APPROACH: Pick the first string of array, compare every character of this string with every corresponsing character of all the rest of the strings, if ismatch found, take out the matching substring and return it. TC: O(n*m), Sc: O(1).
// OPTIMAL_APPROACH: If we sort the array, then the first and last strings will be the most different. So, the common prefix of all strings = common prefix between first and last strings (after sorting).
package String;

import java.util.Arrays;

public class Longest_Common_Prefix {
    public static void main(String [] args){
        String[] sample = {"flower", "flow", "float"};
        System.out.println(longestCommonPrefix(sample));
    }

    public static String longestCommonPrefix_BRUTEFORCE(String[] strs) {
        if(strs.length==0 || strs==null) return "";
        String prefix = strs[0];
        for(int i=1; i<strs.length;i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.length()==0) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix_Better(String[] strs) {
        if(strs.length==0 || strs==null) return "";
        for(int i=0; i<strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length;j++){
                if(i==strs[j].length() || c!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];

    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        int i=0;
        while(i<first.length() && i<last.length() && first.charAt(i) == last.charAt(i)){i++;}
        return first.substring(0,i);
    }
}
