package DoublyLinkedList;

class Node
{
    int data;
    Node next;
    Node back;

    public int getData()
    {
        return this.data;
    }
    public Node getNext()
    {
        return this.next;
    }
    public void setNext(Node next)
    {
        this.next = next;
    }
    public Node getBack()
    {
        return this.back;
    }
    public void setBack(Node back)
    {
        this.back =back;
    }
    public Node(int data)
    {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}
public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        head.setBack(newNode);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.setBack(tail);
        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        if (position > size || position < 0) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 0) {
            head.setBack(newNode);
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }
        int pointer = 0;
        Node counter = head;
        while (pointer < position - 1) {
            counter = counter.getNext();
            pointer++;
        }
        newNode.setNext(counter.getNext());
        newNode.getNext().setBack(newNode);
        counter.setNext(newNode);
        newNode.setBack(counter);
        size++;
    }

    public void deleteFromStart() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }
        Node temp = head.getNext();
        head.getNext().setBack(null);
        head.setNext(null);
        head = temp;
        size--;
    }

    public void deleteFromEnd() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
            size--;
        }
        Node temp = tail.getBack();
        tail.getBack().setNext(null);
        tail.setBack(null);
        tail = temp;
        size--;
    }

    public void deleteAtPosition(int position) {
        if (position > size || position < 0) {
            return;
        }
        if (position == 0) {
            deleteFromStart();
            return;
        }
        int pointer = 0;
        Node counter = head;
        while (pointer < position - 1) {
            counter = counter.getNext();
            pointer++;
        }
        Node delete = counter.getNext();
        counter.setNext(counter.getNext().getNext());
        counter.getNext().setBack(counter);
        delete.setBack(null);
        delete.setNext(null);
        size--;

    }

    public void printFromBack() {
        Node counter = tail;
        while (counter != null) {
            System.out.print(counter.getData() + " <- ");
            counter = counter.getBack();
        }
        System.out.println("Null");
    }

    public int Middle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getData();
    }

    public void printDLL() {
        int pointer = 0;
        Node counter = head;
        while (counter != null) {
            System.out.print(counter.getData() + " -> ");
            counter = counter.getNext();
            pointer++;
        }
        System.out.println("Null");
        System.out.println("size : " + size);
    }


    public void deleteAllOccurence(int k) {
        if (head == null)
        {
            return;
        }
        Node temp = head;
        while(head!=null && head.getData() == k) {
            head = head.getNext();
            if(head!=null){head.setBack(null);}
            size--;
        }
        temp = head;
        while (temp != null) {
            if(temp.getData()==k)
                {
//                    Node prev = temp.getBack();
//                    Node next = temp.getNext();
//
//                    if(prev!=null){prev.setNext(next);}
//                    if(next!=null){next.setBack(null);}
//
////                    Node toDelete = temp;
////                    temp = temp.getNext();
////
////                    // Unlink the node to be deleted
////                    toDelete.setNext(null);
////                    toDelete.setBack(null);
                    Node current = temp;
                    temp = temp.getNext();
                    current.getBack().setNext(temp);
                    temp.setBack(current.getBack());
                    current.setNext(null);
                    current.setBack(null);
                    size--;
                }
            else {
                temp = temp.getNext();
            }
            }
        }


        public static void main (String[]args)
        {
            DoublyLinkedList d = new DoublyLinkedList();
            d.insertAtBeginning(40);
            d.insertAtBeginning(33);
            d.insertAtEnd(56);
            d.insertAtBeginning(6);
            d.insertAtEnd(56);
            d.insertAtEnd(67);
            d.insertAtBeginning(56);

            d.insertAtPosition(2, 39);
            //        d.deleteFromStart();
            //        d.deleteFromEnd();
            d.deleteAtPosition(2);
            d.printDLL();
            d.printFromBack();
            System.out.println(d.Middle());
            d.deleteAllOccurence(56);
            d.printDLL();
        }
    }

