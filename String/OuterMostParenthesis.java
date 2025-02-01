package String;

public class OuterMostParenthesis
{
    public static void main(String[] args)
    {
        String str = "(()())(())((()))";
        System.out.println(removeOuterParenthesis(str));
    }
    public static String removeOuterParenthesis(String s)
    {
        StringBuilder stringBuilder = new StringBuilder();
        int count=0;
        for(int i = 0; i<s.length(); i++)
        {
            if( s.charAt(i) == ')')
            {
                count-=1;
            }
            if(count != 0)
            {
                stringBuilder.append(s.charAt(i));
            }
            if( s.charAt(i) == '(' )
            {
                count+=1;
            }
        }
        return stringBuilder.toString();
    }
}
