package Stack;

import java.sql.SQLOutput;

public class Array_Stack
{
    public static void main(String[] args)
    {
        Implementation_Stack_Array A = new Implementation_Stack_Array();

        A.push(2);
        A.push(3);
        A.push(4);
        A.push(5);
        A.pop();
        System.out.println(A.topOfStack());
        System.out.println(A.size());
        A.display();
    }

}


class Implementation_Stack_Array
{
    private int [] arr = new int[1000];
    private  int top = -1;

    public void push(int data)
    {
        top+=1;
        arr[top] = data;
        return;
    }

    public void pop()
    {
        if(top<0) return;
        top--;
    }
    public int topOfStack()
    {
        return arr[top];
    }
    public int size()
    {
        return (top+1);
    }

    public void display()
    {
        if(top<0) System.out.println("Stack is Empty");
        for(int i=0; i<=top; i++)
        {
            System.out.print(arr[i]+" || ");
        }
        return;
    }
}
