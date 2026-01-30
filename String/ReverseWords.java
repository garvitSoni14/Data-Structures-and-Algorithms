package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseWords
{
    public static void main(String [] args)
    {
        String str = "Hello this is my DSA Series !      ";
//        reverseWords(str);
        System.out.println(reverseWordsBest(str));
    }

    public static String reverseWords(String s)
    {
        String arr[] = s.split(" +");
       StringBuilder stringBuilder = new StringBuilder();
       for(int i = arr.length-1; i>=0 ;i--)
       {
           stringBuilder.append(arr[i]);
           stringBuilder.append(" ");
       }
        return stringBuilder.toString().trim();
    }

    public static String reverseWordsBest(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for(char c: s.toCharArray()){
            if(c !=' '){
                word.append(c);
            }
            else if( c==' ' && word.length()>0){
                res.add(word.toString());
                word.setLength(0);
            }
        }
        if(word.length() > 0){
            res.add(word.toString());
        }
        Collections.reverse(res);
        return String.join(" ", res);

    }

}
