package Stack;

public class Stack_Using_LL
{
    public static void main(String[] args)
    {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.display();
        System.out.println(s.length());
        s.pop();
        s.pop();
        s.display();
        System.out.println(s.peek());
        System.out.println(s.length());
    }
}

class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class Stack
{
    Node top;
    Node head;
    int size;
    Stack()
    {
        head = null;
        top = null;
        size = 0;
    }

    public void push(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head = newNode;
            top = head;
            size++;
            return;
        }
        top.next = newNode;
        top = newNode;
        size++;
    }
    public void pop() {
        if (top == null) return;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        top = temp;
        size--;
    }

    public int peek()
    {
        return top.data;
    }

    public int length()
    {
        return size;
    }

    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
