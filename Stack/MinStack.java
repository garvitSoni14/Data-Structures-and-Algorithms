package Stack;

import java.util.Stack;
public class MinStack {
    public static void main(String[] args)
    {
        MinStackImpl s =new MinStackImpl();
        s.push(21);
        s.push(34);
        s.push(12);
        s.push(13);
        System.out.println(s);
        System.out.println(s.getMin());
        s.pop();
        s.pop();

        System.out.println(s.getMin());
    }
}

class MinStackImpl
{
    Stack<Long> st = new Stack<>();
    Long mini = Long.MAX_VALUE;

    public void push(int value)
    {
        Long val = Long.valueOf(value);
        if(st.isEmpty())
        {
            mini= val;
            st.push(val);
        }
        else {
            if(val<mini)
            {
                st.push(2*val-mini);
                mini = val;
            }
            else {
                st.push(val);
            }
        }
    }
    public void pop()
    {
        if(st.isEmpty()) return;
        Long val = st.pop();
        if(val<mini)
        {
            mini=2*mini-val;
        }
    }

    public int top()
    {
       Long val = st.peek();
       if(val<mini)
       {
           return mini.intValue();
       }
       return val.intValue();
    }
    public int getMin()
    {
        return mini.intValue();
    }
    @Override
    public String toString()
    {
        return "Stack " + st.toString() ;
    }


}
