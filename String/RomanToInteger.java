// Approach: Reverse traverse: if the current Roman Symbol is smaller than previous roman symbol,
// then its value will be subtracted from previous(bigger) value.
// Other wise the current Roman Symbol's value will be added to the answer. TC: O(n), SC: O(1)
package String;

public class RomanToInteger
{
    public static void main(String[] args)
    {
        String str = "LX";
        System.out.println(romanToInteger(str));
    }

    public static int romanToInteger(String s)
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
