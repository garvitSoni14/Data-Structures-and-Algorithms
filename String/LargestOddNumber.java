package String;

public class LargestOddNumber
{
    public static void main(String [] args)
    {
        String str = "45999949";
        System.out.println(largestOddNumber(str));
    }

    public static String largestOddNumber(String s)
    {
        for( int i = s.length()-1 ; i>=0 ; i--)
        {
            if( ( (int) s.charAt(i) & 1) ==1)
            {
                return (s.substring(0,i+1));
            }
        }
        return "";
    }
}
