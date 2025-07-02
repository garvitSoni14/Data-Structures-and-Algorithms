package Recursion.Recursion_Basics;

public class CheckPalindrome {
    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(isPalindrome(s, 0, s.length() - 1));
    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (start > end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        isPalindrome(s, start + 1, end - 1);
        return true;
    }
}
// TC: O(n)
//SC: O(n)


                        /*   LEETCODE SOLUTION
                        class Solution {
                        public boolean isPalindrome(String s) {
                            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                            return palindromeCheck(s, 0, s.length()-1);

                        }

                        public boolean palindromeCheck(String s, int start, int end){
                            if(start>end) return true;
                            if(s.charAt(start)!= s.charAt(end)) return false;
                            return palindromeCheck(s, start+1, end-1);

                        }

                    }
                         */

