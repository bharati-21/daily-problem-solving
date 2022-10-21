/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode prevToMiddleNode = getPreviousNodeToMiddle(head);
        prevToMiddleNode.next = prevToMiddleNode.next.next;
        return head;
    } 

    private ListNode getPreviousNodeToMiddle(ListNode head) {
        ListNode prev = null, fast = head;
        while(fast != null && fast.next != null) {
            prev = (prev == null) ? head : prev.next;
            fast = fast.next.next;
        }
        return prev;
    }
}
