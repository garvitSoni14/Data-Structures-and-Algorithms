package Recursion.Recursion_Basics;

public class Sum_of_DIgits {

    public static void main(String [] args){
        int n = 52314;
        System.out.println(sumDigits(n));
    }
    public static int sumDigits(int n){
        if(n<10) return n;
        return sumDigits(n/10)+n%10;
    }



}
