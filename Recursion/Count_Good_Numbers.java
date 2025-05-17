package Recursion;

public class Count_Good_Numbers {
    public static long mod = 1_000_000_007;
    public static int countGoodNumbers(long n) {
        long ev = (n+1)/2;
        long od = n/2;
        long even = pow(5, ev);
        long odd = pow(4,od);
        return (int) ((even*odd)%mod);
    }
    public static long pow(long base, long pov)
    {
        if(pov == 0) return 1;
        long temp = pow(base, pov/2);
        if(pov%2==0) return (temp*temp)% mod;
        else return (temp*temp*base)%mod;
    }

    public static void main(String[] args)
    {
        long n = 50;
        System.out.println(countGoodNumbers(n));

    }
}
