package String;

public class StringIntegerATOI {
    public static void main(String[] args) {
        String str = "+1";
        System.out.println(ATOI(str));
    }

   public static int ATOI(String s)
   {
       s = s.trim(); // Remove leading/trailing spaces
       if (s.isEmpty()) return 0;

       int sign = 1, i = 0, res = 0;

       // Handle sign
       if (s.charAt(0) == '-' || s.charAt(0) == '+') {
           sign = (s.charAt(0) == '-') ? -1 : 1;
           i++;
       }

       for (; i < s.length(); i++) {
           char c = s.charAt(i);
           if (c < '0' || c > '9') break; // Stop if non-digit is encountered

           int digit = c - '0';

           // **Overflow check before updating res**
           if (res > (Integer.MAX_VALUE - digit) / 10) {
               return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
           }

           res = res * 10 + digit;
       }

       return res * sign;
   }
}
