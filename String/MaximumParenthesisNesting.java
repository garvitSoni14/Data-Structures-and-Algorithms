package String;

public class MaximumParenthesisNesting
{
    public static void main(String [] args)
    {
        String str = "(111)((232)23)((()))((((()))))";
        System.out.println(maximumParenthesisNesting(str));
    }

    public static int maximumParenthesisNesting(String s)
    {
        int res=-1;
        int point=0;
        for(char c: s.toCharArray())
        {
            if(c=='('){point++;}
            if(c==')'){point--;}
            res = Math.max(res,point);
        }
        return res;
    }
}
