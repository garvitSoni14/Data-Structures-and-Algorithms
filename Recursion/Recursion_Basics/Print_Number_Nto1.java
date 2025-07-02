package Recursion.Recursion_Basics;

public class Print_Number_Nto1 {

    public static void main(String[] args){
        int n = 9;
        printNToOne(n);
    }

    public static void printNToOne(int n){
        if (n==0) return;
        System.out.println(n);
        printNToOne(n-1);
    }
}
