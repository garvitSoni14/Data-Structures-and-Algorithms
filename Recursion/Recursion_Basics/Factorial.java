package Recursion.Recursion_Basics;

public class Factorial {
    public static void main(String[] arga){
        int n = 5;
        System.out.println(factorial(n));
    }

    public static int factorial(int n){
        if(n==1) return 1;
        return n * factorial(n-1);
    }
}

// TC: O(n)
// SC: O(n)
