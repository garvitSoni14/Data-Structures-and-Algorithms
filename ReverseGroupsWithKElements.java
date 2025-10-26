//public class ReverseGroupsWithKElements {
//
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     * int val;
//     * ListNode next;
//     * ListNode() {}
//     * ListNode(int val) { this.val = val; }
//     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode temp = head, prevLast = null;
//        while (temp != null) {
//            ListNode kthNode = getKthNode(temp, k);
//            if (kthNode == null) {
//                if (prevLast != null) {
//                    prevLast.next = temp;
//                }
//                break;
//            }
//            ListNode nextNode = kthNode.next;
//            kthNode.next = null;
//            rev(temp);
//            if (temp == head) {
//                head = kthNode;
//            } else {
//                prevLast.next = kthNode;
//            }
//            prevLast = temp;
//            temp = nextNode;
//        }
//        return head;
//    }
//
//    public ListNode getKthNode(ListNode temp, int k) {
//        k -= 1;
//        while (temp != null && k > 0) {
//            k--;
//            temp = temp.next;
//        }
//        return temp;
//    }
//
//    public ListNode rev(ListNode head) {
//        ListNode temp = head;
//        ListNode prev = null;
//        while (temp != null) {
//            ListNode front = temp.next;
//            temp.next = prev;
//            prev = temp;
//            temp = front;
//        }
//        return prev;
//    }
//
//}
