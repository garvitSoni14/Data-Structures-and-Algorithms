package Queue;

public class Queue_Using_LL
{
    public static void main(String[] args)
    {
        Queue q = new Queue();
        q.push(1);
        q.push(2);
        q.push(3);
//        q.pop();
        q.display();
//        System.out.println(q.length());
//        System.out.println(q.Front());
//        System.out.println(q.Tail());
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

class Queue
{
    Node front;
    Node tail;
    int size;

    Queue()
    {
        front = null;
        tail = front;
        size = 0;

    }

    public void push(int data)
    {
        Node newNode = new Node(data);
        if(front==null)
        {
            front = newNode;
            tail = front;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;

    }

    public void pop()
    {
        if(front==null)return;
        Node prev=front;
        front = front.next;
        prev=null;
        size--;
    }

    public int length()
    {
        return size;
    }
    public int Front()
    {
        return front.data;
    }
    public int Tail()
    {
        return tail.data;
    }

    public void display()
    {
        Node temp=front;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
}
