package Recursion.Recursion_Basics;

public class Fibonacci {

    public static void main(String [] args){
        int n = 10;
        System.out.println(findFibonacci(n));
    }

    public static int findFibonacci(int n){
        if(n<=1) return n;
        int last = findFibonacci(n-1);
        int secondLast = findFibonacci(n-2);
        return last+secondLast;
    }

    // TC: O(2^N)
    // SC: O(N)

    public static void findFibonacci_BruteForce(int n){
        int firstNum = 0, secondNum = 1, nextNum;
        for(int i=0;i<=n;i++){
            System.out.print(firstNum + " ");
            nextNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = nextNum;
        }
    }
    // TC: O(N)
    // SC: O(1)
}
