package Recursion.Recursion_Basics;

public class Print_N_Times {

    public static void main(String[] args){
        printNtimes(4);
    }

    public static void printNtimes(int n) {
        if (n == 0) return;
        System.out.println(n + "th iteration");
        printNtimes(--n);
    }
}
