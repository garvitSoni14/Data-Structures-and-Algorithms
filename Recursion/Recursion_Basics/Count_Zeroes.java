package Recursion.Recursion_Basics;

public class Count_Zeroes {
    public static void main(String[] arga){
        int n = 1020300;
        System.out.println(countZero(n));
    }

    public static int countZero(int n){
        if(n==0) {
            return 0;
        }
        if(n%10 == 0) return 1+countZero(n/10);
        return countZero(n/10);
    }

}


