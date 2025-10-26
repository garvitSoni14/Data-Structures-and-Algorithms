package SinglyLinkedList;

public class MergeKSortedLists {

//    public static void main (String[] args){
//        lists = [[1,4,5],[1,3,4],[2,6]]
//        mergeKLists(lists)
//    }

//    public ListNode mergeKLists_OPTIMAL(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//
//        // Min-heap: stores nodes based on their val
//        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
//
//        // Step 1: Add all non-null heads to heap
//        for (ListNode node : lists) {
//            if (node != null) pq.add(node);
//        }
//
//        // Dummy node to simplify merging
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//
//        // Step 2: Build the merged list
//        while (!pq.isEmpty()) {
//            ListNode smallest = pq.poll();
//            tail.next = smallest;
//            tail = tail.next;
//
//            if (smallest.next != null) pq.add(smallest.next);
//        }
//
//        return dummy.next;
//    }

//    public static ListNode mergeKLists_BRUTEFORCE(ListNode[] lists) {
//        List<Integer> values = new ArrayList<>();
//        for (ListNode node : lists) {
//            while (node != null) {
//                values.add(node.val);
//                node = node.next;
//            }
//        }
//
//        Collections.sort(values);
//
//        ListNode dummy = new ListNode(0);
//        ListNode curr = dummy;
//        for (int val : values) {
//            curr.next = new ListNode(val);
//            curr = curr.next;
//        }
//
//        return dummy.next;
//    }


}
