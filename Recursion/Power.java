package Recursion;

public class Power {
    public static double myPow(double x, int n)
    {
        long N = (long)n;
        if(n<0)
        {
            x = 1/x;
            N = -N;
        }
        return pow(x, N);
    }
    public static double pow(double x, Long n)
    {
        if(n==0) return 1;
        double temp = pow(x, n/2);
        if(n%2==0) return temp*temp;
        else return temp*temp*x;
    }
    public static void main(String[] args)
    {
        System.out.println(myPow(4.0,2));
    }
}


