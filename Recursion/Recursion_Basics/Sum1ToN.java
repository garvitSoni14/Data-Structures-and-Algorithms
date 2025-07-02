package Recursion.Recursion_Basics;

public class Sum1ToN {

    public static void main(String[] arga){
        int n = 3;
        System.out.println(sumNaturalNumbers(n));
    }

    public static int sumNaturalNumbers(int n){
        if(n==0) return 0;
        return n + sumNaturalNumbers(n-1);}
}

//TC: O(n)
//SC: O(n)