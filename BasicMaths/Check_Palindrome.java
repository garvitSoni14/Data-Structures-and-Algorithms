package BasicMaths;

public class Check_Palindrome {
    public static void main(String[] args){
        int n=123454321;
        System.out.println(checkPalindrome(n));
    }
    public static boolean checkPalindrome(int x){
        int rev = 0;
        int dup = x;
        while(x!=0){
            int digit = x%10;
            x = x/10;
            if(rev>Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE&&digit>7))break;
            if(rev<Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE&&digit>7))break;
            rev = rev*10+digit;
        }

        if(dup == rev) return true;
        return false;
    }

    // MOstOptimal one:
    public static boolean isPalindrome2(int x) {
//        x<0 (Negative number is never a palindrom)
//        x%10 && x!= 0 (All numbers ending with zero , excluding 0 itself is also not a palindrome)
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversedHalf = 0;
        while (x > reversedHalf) {
            int digit = x % 10;
            reversedHalf = reversedHalf * 10 + digit;
            x /= 10;
        }
        return (x == reversedHalf) || (x == reversedHalf / 10);
    }
}
