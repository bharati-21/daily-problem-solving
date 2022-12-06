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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode oddPtr = head;
        ListNode evenPtr = head.next;

        ListNode evenHead = evenPtr;
        ListNode oddHead = head;
        
        while(evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;

            evenPtr.next = oddPtr.next;
            evenPtr = evenPtr.next;
        }

        oddPtr.next = evenHead;

        return head;
    }
}
