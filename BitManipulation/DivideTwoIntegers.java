package BitManipulation;

public class DivideTwoIntegers {

    public static void main(String [] args){
        int result = divide(15,2);
        System.out.println(result);
    }

    public static int divide(int dividend, int divisor)
        {   if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if (dividend == divisor)
            return 1;

        boolean sign = !((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor >= 0));

        long n = Math.abs((long) dividend), d = Math.abs((long) divisor), ans = 0;

        while (n >= d) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            ans += (1L << count);
            n -= (d * (1L << count));
        }

        return sign ? (int) ans : (int) (-ans);
    }
    public static int divide_BRUTEFORCE(int dividend, int divisor) {
    int sum=0, quotient=0;
    while(sum+divisor <= dividend){
        sum+=divisor;
        quotient+=1;
    }
    return quotient;
    }
}
