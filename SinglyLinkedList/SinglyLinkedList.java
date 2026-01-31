package SinglyLinkedList;

import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LL{
    Node head = null;
    Node tail = null;
    int size = 0;

    public void add(Node node){
        if(head == null) { head = tail = node;   size++;  }
        else {  tail.next = node; tail = node;  size++;  }
    }
    public void addToStart(Node node){
        if(head ==null){head = tail = node; size++; }
        else{
            node.next = head;
            head = node;
            size++;
        }

    }
    public void addInBetween(Node node, int index){
        if(index < 0 || index> size) { System.out.println("Invalid Index"); return; }
        if(index == 0) { addToStart(node); return; }
        if(index == size){  add(node); return; }

        Node prev = head;
        for(int i=0; i<index-1; i++){
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        size++;

    }

    public void deleteFromEnd(){
        if(head == null) return;
        if(head == tail) { head = tail = null; size--; return; }
        Node temp = head;
        while(temp.next!=tail){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }
    public void deleteFromStart(){
        if(head == null) return;
        if(head == tail) { head = tail = null; size--; return; }
        Node temp = head;
        head = head.next;
        temp.next=null;
        size--;
    }
    public void deleteFromIndex(int index){
        if(index<0 || index>=size) { System.out.println("Invalid index"); return; }
        if(head == tail){ head = tail = null; size--; return; }
        if(index == 0) { deleteFromStart(); return; }
        if(index == size-1) {deleteFromEnd(); return; }
        if(index<size){
            Node prev = head;
            for(int i=1; i<index-1; i++){
                prev = prev.next;
            }
            prev.next = prev.next.next;
            size--;
        }
        return;
    }

    public int searchFor(int key){
        if(head == null) return -1;
        Node temp = head;
        int keyIndex = 1;
        while(temp != null){
            if(temp.data == key){
                return keyIndex;
            }
            keyIndex++;
            temp  =temp.next;
        }
        return -1;
    }

    public int size(){ return this.size;}

    public int middleElement(){
        if(head==null) return -1;
        if(head ==tail) return head.data;
        Node tortoise=head;
        Node hare = head;
        while(tortoise.next!=null && tortoise.next.next != null){
            tortoise = tortoise.next.next;
            hare = hare.next;
        }
        return hare.data;
    }

    public void reverse(){
        if(head == null) return ;
        if(head == tail) return ;
        Node prev = null;
        Node temp =head;
        while(temp!= null){
            Node front =temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        head = prev;
    }

    public boolean detectCycle(){
        if(head == null) return false;
        Node fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }

//    public boolean detectCycle(){
//        HashSet<Node> visited = new HashSet<>();
//        if(head == null) return false;
//        Node temp= head;
//        while(temp!=null){
//            if(visited.contains(temp)) return true;
//            visited.add(temp);
//        }
//        return false;
//    }

    public Node startOfCycle() {
        if(head == null) return null;
        Node fast = head, slow= head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                slow = head;
                while(slow !=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
//    public Node startOfCycle(){
//            HashSet<Node> visited = new HashSet<>();
//            if(head == null) return null;
//            Node temp= head;
//            while(temp!=null){
//                if(visited.contains(temp)) return temp;
//                visited.add(temp);
//            }
//            return null;
//        }

    public int lengthOfCycle(){
        int length = 0;
        Node start= this.startOfCycle();
        Node temp = start.next;
        while(temp!=start){
            length++;
            temp= temp.next;
        }
        return length;
    }

    public boolean isPalindrome(){
        if(head == null || head == tail) return true;

//         finding middle node
        Node tortoise = head, hare = head;
        while(hare.next!=null && hare.next.next!=null){
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        Node secondHalf = reverseLL(tortoise.next);
        Node first = head, second = secondHalf;
        while(second!=null){
            if(first.data != second.data){
                return false;
            }
            first = first.next;
            second= second.next;
        }
        return true;
    }

    public Node reverseLL(Node node){
        Node prev = null;
        while(node != null){
            Node next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public Node seggregateLL(){
        if(head == null ) return null;
        if(head == tail) return head;
        Node evenHead = null, evenTail = null, oddHead = null,oddTail = null, current = head;
        while(current != null){
            if(current.data % 2 == 0){
                if(evenHead == null){
                    evenHead = current;
                    current = current.next;
                }
                else{
                    evenTail.next = current;
                    evenTail = current;
                }
            }
            else{
                if(oddHead == null){
                    oddHead = current;
                    oddTail = current;
                }
                else{
                    oddTail.next = current;
                    oddTail = current;
                }
            }
            current = current.next;
        }
        if(evenHead == null) return oddHead;
        if(oddHead == null) return evenHead;
        evenTail.next = oddHead;
        oddTail.next = null;
        return evenHead;
    }

    public void deleteFromEnd(int n){
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy, slow = dummy;
        for(int i = 0;i < n; i++){ fast = fast.next; }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next =slow.next.next;
        head= dummy.next;
        size--;
    }

//    public void deleteFromEnd(int n){
//        int index = this.size - n + 1;
//        Node temp = head;
//        for(int i = 1; i<index-1; i++){ temp = temp.next; }
//        temp.next = temp.next.next;
//        size--;
//    }

    public void deleteMiddle(){
        if(head == null) return ;
        if(head == tail) { head = tail = null; size--; }
        Node fast = head.next.next;
        Node slow = head;
        while(fast.next != null && fast.next.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
//        System.out.println(slow.data);
        slow.next = slow.next.next;
        size--;
        return;
    }

//    public void sortLL(){
//        if(head == null) return ;
//        List<Integer> list = new ArrayList<>();
//        Node temp = head;
//        while(temp!=null) {
//            list.add(temp.data);  temp = temp.next;
//        }
//        Collections.sort(list);
//        temp = head;
//        int i = 0;
//        while(temp!=null ){
//            temp.data= list.get(i);
//            i++;
//            temp = temp.next;
//        }
//        return;
//    }

    public Node findIntersection(LL l2){
        HashSet<Node> hashSet = new HashSet<>();
        Node temp = this.head;
        while(temp!=null){
            hashSet.add(temp);
            temp = temp.next;
        }
        temp = l2.head;
        while(temp != null){
            if(hashSet.contains(temp)) return temp;
            temp = temp.next;
        }
        return null;
    }

//    public Node findIntersection(LL l2){
//        Node head1 = this.head;
//        while(head1 != null){
//            Node head2 = l2.head;
//            while(head2 != null){
//                if(head1 == head2) return head1;
//                head2 = head2.next;
//            }
//            head1 = head1.next;
//        }
//        return null;
//    }

    public Node add1(){
        int carry = recursive(head);
        if(carry == 1){
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    private int recursive(Node node){
        if(node == null) return 1;
        int carry = recursive(node.next);
        int sum = node.data + carry;
        node.data = sum%10;
        return sum/10;
    }

//    public Node add1(){
//        long num = 0;
//        Node temp = head;
//        while(temp != null){
//            num = num*10 + temp.data;
//            temp =temp.next;
//        }
//        num = num+1;
//        String s = Long.toString(num);
//        Node dummy = new Node(0);
//        temp = dummy;
//        for(char c: s.toCharArray()){
//            temp.next = new Node(c-'0');
//            temp = temp.next;
//        }
//        return dummy.next;
//    }

    public Node addTwoNumbers(Node l2){
        Node l1 = this.head;
        Node dummy = new Node(0);
        Node temp = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int sum=0;
            if(l1 != null){
                sum += l1.data;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.data;
                l2 = l2.next;
            }
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    public void printLL(){
        Node temp = head;
        while(temp!=null){System.out.print(temp.data+" -> "); temp = temp.next;}
    }

}
public class SinglyLinkedList
{
    public static void main(String[] args) {
        LL l = new LL();
        l.add(new Node(1));
        l.add(new Node(2));
        l.add(new Node(3));


        LL l2 = new LL();
        l2.add(new Node(1));
        l2.add(new Node(2));
        l2.add(new Node(3));


        LL l3= new LL();
        l3.head = l.addTwoNumbers(l2.head);
        l3.printLL();





    }
}