package Recursion.Recursion_Basics;

public class CountDIgits {

    public static void main(String [] args){
        int n = 6;
        System.out.println(countDigits(n));
    }

    public static int countDigits(int n){
        if(n<10) return 1;
        return 1+countDigits(n/10);
    }


}
