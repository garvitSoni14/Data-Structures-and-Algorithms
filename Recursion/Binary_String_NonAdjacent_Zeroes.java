package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Binary_String_NonAdjacent_Zeroes {
    public static List<String> validStrings(int n) {
        List<String> fr = new ArrayList<>();
        String co = "";
        solve(n,n,n,co,fr);
        return fr;
    }

    public static void solve(int zeroes, int ones, int size, String co, List<String> fr)
    {
        if(co.length() == size)
        {
            fr.add(co);
            return;
        }
        if(zeroes==size)
        {
            solve(zeroes-1, ones, size, co+'0', fr);
        }
        else if(zeroes>=ones && (co.length()>0 && co.charAt(co.length()-1)!='0'))
        {
            solve(zeroes-1, ones, size, co+'0', fr);
        }
        solve(zeroes, ones-1, size, co+'1', fr);
    }
//        public static void solve(int zeroes, int ones, int size, String co, List<String> fr)
//{
//    if(co.length()==size){
//        fr.add(co);
//        return;}
//    if(zeroes==ones)
//    {
//        solve(zeroes-1, ones, size, co+'0', fr);
//    }
//    else if(zeroes>=ones && ( co.length()>0 && co.charAt(co.length()-1)!='0'))
//    {
//        solve(zeroes-1, ones, size, co+'0', fr);
//    }
//    solve(zeroes, ones-1, size, co+'1', fr);
//}

    public static void main(String[] args)
    {
        System.out.println(validStrings(3));
    }

    }
