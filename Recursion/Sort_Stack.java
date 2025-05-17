package Recursion;

import java.util.Stack;

public class Sort_Stack {
    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(41);
        st.push(6);
        st.push(1444);
        sortStack(st);
        System.out.println(st.toString());
    }
    public static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int popped = stack.pop();
        sortStack(stack);
        insertSorted(stack, popped);
    }

    public static void insertSorted(Stack<Integer> stack, int element)
    {
        if(stack.isEmpty()||stack.peek()<=element)
        {
            stack.push(element);
            return;
        }
        int Last = stack.pop();
        insertSorted(stack, element);
        stack.push(Last);
    }


}
