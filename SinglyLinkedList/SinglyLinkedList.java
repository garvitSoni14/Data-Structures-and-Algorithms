package SinglyLinkedList;

class Node{
    int data;
    Node next;

    public Node(int data) {this.data=data; this.next=null;}

    public int getData() {return data;}

    public Node getNext() {return next;}

    public void setNext(Node next) {this.next = next;}
}

class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

//..................................................................................................

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
        if (tail == null) tail = head;
        size++;
    }

//..................................................................................................

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

//..................................................................................................

    public void insertAtPosition(int position, int data) {
        if (position > size || size < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == size) {
            insertAtEnd(data);
            size++;
            return;
        }
        if (position == 0) {
            insertAtBeginning(data);
        }
        else {
            Node newNode = new Node(data);
            Node counter = head;
            for (int i = 0; i < position - 1; i++) {
                counter = counter.getNext();
            }
            newNode.setNext(counter.getNext());
            counter.setNext(newNode);
        }
        size++;
    }

//..................................................................................................

    public void deleteByValue(int value) {
        if (head == null) return;

        if (head.getData() == value) {
            head = head.getNext();
            if (head == null) tail = null;
            size--;
            return;
        }
        Node counter = head;
        while (counter.getNext() != null && counter.getNext().getData() != value) {
            counter = counter.getNext();
        }
        if (counter.getNext() == null) {
            System.out.println("Value not found");
            return;
        }
        counter.setNext(counter.getNext().getNext());
        if (counter.getNext() == null) tail = counter;
        size--;
    }

//..................................................................................................

    public void deleteByPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position > size || position < 0) {
            System.out.println("Invalid Position");
            return;
        }
        if(position == 0)
        {
            head = head.getNext();
            size--;
            return;
        }
        Node counter = head;
        for(int i= 0; i<position-1;i++)
        {
            counter = counter.getNext();
        }
        counter.setNext(counter.getNext().getNext());
        if(counter.getNext()==null){tail = counter;}
        size--;
    }

//..................................................................................................

    public void deleteFromBeginning()
    {
        head = (head.getNext());
        size--;
    }

//..................................................................................................

    public void deleteFromEnd()
    {
        Node counter = head;
        int pointer = 0;
        while(pointer<size-1)
        {
            counter = null;
            pointer++;
        }
        size--;
    }

//..................................................................................................

    public int search(int key)
    {
        Node counter = head;
        int index = 0;
        while (counter.getNext() !=null)
        {
            index+=1;

            if(counter.getData() == key)
            {
                return index;
            }counter = counter.getNext();

        }
        return -1;
    }

//..................................................................................................

    public int middle()
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.getNext()!=null)
        {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getData();
    }

//..................................................................................................

    public Node revIter(Node initial)
    {
        Node prev = null, current = initial, nextt;
        while(current != null)
        {
            nextt = current.getNext();
            current.setNext(prev);
            prev = current;
            current = nextt;
        }
        head = prev;
        return head;
    }

//..................................................................................................

    public Boolean detectLoop()
    {
        Node slow=head, fast=head;
        while(fast!=null && fast.getNext()!=null)
        {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(fast==slow){return true;}
        }
        return false;
    }

//..................................................................................................

    public Node DetectStartOfLoop()
    {
        Node slow = head ,  fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow==fast)
            {
                slow = head;
                while(slow!=fast)
                {
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
                return slow;
            }
        }
        return null;
    }

//..................................................................................................

    public Boolean isPalindrome(Node head)
    {
        if(head == null || head.next == null) return  true;
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        Node secondHalf = revIter(slow);
        Node temp2 = secondHalf;
        Node temp1 = head;
        while(temp2!=null)
        {
            if(temp1.getData() != temp2.getData())
            {
                revIter(temp2);
                return false;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        revIter(secondHalf);
        return true;
    }

//..................................................................................................

    public void printList(Node initializer)
    {   Node count = initializer;
        while(count != null)
        {
            System.out.print(count.getData()+"->");
            count = count.getNext();
        }
        System.out.println("null");
    }

//..................................................................................................

    public Node seggregateEvenOdd(Node head)
    {
        Node oddHead = new Node(-1), oddTail = oddHead;
        Node evenHead = new Node(-1), evenTail= evenHead;
        Node current = head, temp;
        while(current!=null)
        {
            temp = current;
            current = current.getNext();
            temp.setNext(null);

            if(temp.getData() %2 !=0)
            {
                oddTail.setNext(temp);
                oddTail = temp;
            }
            else {
                evenTail.setNext(temp);
                evenTail = temp;
            }
        }
        evenTail.setNext(oddHead.next);
        return evenHead.getNext();

    }

//..................................................................................................

public Node seggregate()
{
    Node oddHead = new Node(-1), oddTail = oddHead;
    Node evenHead = new Node(-1), evenTail= evenHead;
    Node current = head, temp;
    int ind=1;
    while(current!=null)
    {
        temp = current;
        current = current.getNext();
        temp.setNext(null);

        if(ind %2 !=0)
        {
            oddTail.setNext(temp);
            oddTail = temp;
        }
        else {
            evenTail.setNext(temp);
            evenTail = temp;
        }
    }
    evenTail.setNext(oddHead.next);
    return evenHead.getNext();

}

//..................................................................................................

    public void lengthSLL()
    {
        System.out.println(this.size);
    }

//..................................................................................................

    public static void main(String[] args)
    {
        SinglyLinkedList g = new SinglyLinkedList();
        g.insertAtBeginning(12);
        g.insertAtEnd(12);
        g.insertAtEnd(45);
        g.insertAtPosition(0,45);

        g.printList(g.head);
        g.lengthSLL();

//        g.deleteByPosition(2);
//        g.deleteFromBeginning();
//        g.deleteFromEnd();
//        g.printList(g.head);
//        System.out.println(g.search(45));

//        System.out.println(g.middle());

//        g.printList(g.revIter(g.head));
//        System.out.println(g.isPalindrome(g.head));
        g.printList(g.seggregateEvenOdd(g.head));

//
//        g.printList(head);
    }
}

