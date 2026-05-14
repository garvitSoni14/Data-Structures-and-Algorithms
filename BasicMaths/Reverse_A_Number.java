package BasicMaths;

public class Reverse_A_Number {
    public static void main(String[] args){
        int n = 123;
        System.out.println(reverseNumber(n));
    }

    public static int reverseNumber(int number){
        int rev = 0;
        while(number!=0){
            int digit = number%10;
            number = number/10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && digit>7)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && digit<-8)) return 0;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}

//TC:O(log10N+1)
//SC:O(1)


//Integer.MAX_VALUE = 2147483647 (Java में int का सबसे बड़ा मान)
//
//जब हम reverse करते हैं, हर बार rev = rev * 10 + digit होता है।
//
//अगर rev पहले से ही Integer.MAX_VALUE/10 (यानी 214748364) से बड़ा है, तो अगला digit जोड़ने पर overflow हो जाएगा।
//
//अगर rev बिल्कुल बराबर है 214748364 के, तो आखिरी digit सिर्फ 7 तक ही सुरक्षित है।
//
//अगर digit > 7 है, तो overflow होगा।
