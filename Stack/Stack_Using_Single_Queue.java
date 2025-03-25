package Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Stack_Using_Single_Queue
{
    public static void main(String[] args)
    {

        StackUsing1Queue s = new StackUsing1Queue();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.display();
    }
}

class StackUsing1Queue
{
    private Queue<Integer> queue = new LinkedList<>();
    private int size=0;

    public void push(int data)
    {
        queue.add(data);
        for(int i=queue.size();i>1;i--)
        {
            queue.add(queue.poll());
        }
    }
    public void pop()
    {
        System.out.println(queue.poll());
    }
    public void toh()
    {
        System.out.println(queue.peek());
    }

    public void isEmpt()
    {
        System.out.println(queue.isEmpty());
    }
    public void display()
    {
        System.out.println(queue);
    }
}