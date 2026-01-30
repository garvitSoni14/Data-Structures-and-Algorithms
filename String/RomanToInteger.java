// Approach: Reverse traverse: if the current Roman Symbol is smaller than previous roman symbol,
// then its value will be subtracted from previous(bigger) value.
// Other wise the current Roman Symbol's value will be added to the answer. TC: O(n), SC: O(1)
package String;

import java.util.HashMap;

public class RomanToInteger
{
    public static void main(String[] args)
    {
        String str = "LX";
        System.out.println(romanToInt(str));
    }
    public static int romanToInt(String s) {
        int res = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        for(int i=0;i<s.length()-1;i++){
            if( mp.get(s.charAt(i)) < mp.get(s.charAt(i+1)) ){ res -= mp.get(s.charAt(i)); }
            else res+=mp.get(s.charAt(i));
        }
        res+=mp.get(s.charAt(s.length()-1));
        return res;


    }

    public static int romanToIntegerSwitch(String s)
    {
        int count = 0;
        int lastvalue = 0;
        for (int i = s.length()-1; i>=0; i--) {
            int value=0;
            switch (s.charAt(i)) {
                case 'I':
                    value=1;
                    break;
                case 'V':
                    value=5;
                    break;
                case 'X':
                    value=10;
                    break;
                case 'L':
                    value=50;
                    break;
                case 'C':
                    value=100;
                    break;
                case 'D':
                    value=500;
                    break;
                case 'M':
                    value = 1000;
                    break;
            }
            if(value<lastvalue)
            {
                count-=value;
            }
            else
            {
                count+=value;
            }
            lastvalue = value;
        }
        return count;
    }
}
