package Recursion.Recursion_Basics;

public class Print_Number_1toN {
    public static void main(String[] args){
        int n = 9;
        printOneToN_BugVersion(n);
    }


    public static void printOneToN(int n){
        if(n==0) return;
        printOneToN(n-1);
        System.out.println(n);
    }

    public static void printOneToN_BugVersion(int n){
        if(n==0) return;
        printOneToN(n-=1);     // this will print from 0 to 8 cuz here we are assigning N-1 value in each recursion.
        System.out.println(n);
    }
}
/*
1
2
3
4
5
6
7
8
8 - Here the permanent value stored in N is 8 instead of 9
 */

//TC: O(n)
//SC: O(n)
