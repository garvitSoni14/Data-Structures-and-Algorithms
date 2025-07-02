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
}
