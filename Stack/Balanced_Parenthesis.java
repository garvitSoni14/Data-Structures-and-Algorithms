package Stack;

import java.util.Stack;

public class Balanced_Parenthesis {
    public static void main(String[] args)
    {
        String st = "{}((([123]))";
        System.out.println(isParenthesisBalanced(st));
    }

    public static Boolean isParenthesisBalanced(String s)
    {
        Stack<Character> stk = new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c=='{' || c=='(' || c=='[')
            {
                stk.push(c);
            }
            else if(c=='}' || c==')' || c==']')
            {
                if (stk.isEmpty()) {
                    return false;
                }
                char top = stk.pop();
                if((c=='}'&& top!='{') || (c==']'&& top!='[') || (c==')'&& top!='('))
                {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}


