package Recursion.Recursion_Basics;

public class Reverse_String {
    public static void main(String[] arga){
        String s = "abcd";
        System.out.println(reverseString(s));
    }

   public static String reverseString(String s){
        if(s.length()==0) return "";
        return reverseString(s.substring(1))+s.charAt(0);
   }
}

// TC: O(n)
//SC: O(n)