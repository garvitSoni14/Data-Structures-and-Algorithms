package Recursion;

import java.util.Stack;

public class Reverse_Stack {
    public static void rev(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int popped = stack.pop();
        rev(stack);
        insertAtBeginning(stack, popped);
    }
    public static void insertAtBeginning(Stack<Integer> stack, int value)
    {
        if(stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int pop = stack.pop();
        insertAtBeginning(stack,value);
        stack.push(pop);
    }

    public static void main(String[] args)
    {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        rev(st);
        System.out.println(st.toString());
    }
}
