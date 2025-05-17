package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Generate_Paranthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String s = "";
        parenthesis(res,n,0,0,s);
        return res;

    }

    public static void parenthesis(List<String> res, int size, int openB, int closeB, String co)
    {
        if(co.length() == 2*size) {
            res.add(co);
            return;}
        if(openB<size) {
            parenthesis(res, size, openB+1, closeB, co+'(');
        }
        if(closeB<openB) {
            parenthesis(res, size, openB, closeB+1, co+')');
        }
    }
    public static void main(String[] args)
    {
        System.out.println(generateParenthesis(3));
    }
}
