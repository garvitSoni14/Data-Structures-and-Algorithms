package Queue;

import java.util.Stack;

public class Stack_Using_Two_Queues {
    public static void main(String[] args)
    {
StackFrom2Queues s = new StackFrom2Queues();
s.push(1);
s.push(2);
s.push(3);
s.pop();
//s.pop();
s.push(4);
s.push(5);
s.display();
    }
}

class StackFrom2Queues
{
    private Stack<Integer> inputStack = new Stack<>();
    private Stack<Integer> outputStack = new Stack<>();

    public void push(int data)
    {
        inputStack.push(data);
    }

    public void pop()
    {
        if(outputStack.isEmpty())
        {
            while(!inputStack.isEmpty())
            {
                outputStack.push(inputStack.pop());
            }
        }
        System.out.println(outputStack.pop());
        while(!outputStack.isEmpty())
        {
            inputStack.push(outputStack.pop());
        }
    }
    public void peek()
    {
              while(!inputStack.isEmpty())
              {
                  outputStack.push(inputStack.pop());
              }
        System.out.println( outputStack.peek());
    }

    public void display()
    {
        System.out.println(inputStack);
    }
}
