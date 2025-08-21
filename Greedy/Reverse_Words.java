package Greedy;

public class Reverse_Words {

    public static void main(String[] args){
//        String sample = ".i.like.program.very.much.";
        String sample = "v.f..gfc";
        String s = reverseWords(sample);
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        String[] words = s.split("\\.");
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            if(words[i].length()==0) continue;
            if (res.length()>0) res.append(".");
            res.append(words[i]);
        }

        return res.toString();
    }
    // TC: O(n)
    // SC:O(n) //worst case..dot after every character in string



    // leetcode "." -> " "
    public static String reverseWords_(String s) {
        s = s.trim();
        String[] sArray = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(int i=sArray.length-1; i>=0; i--){
            result.append(sArray[i]);
            if(i>0) result.append(" ");
        }
        return result.toString();

    }
}
