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
        int length = getLength(head);
        ListNode prevToMiddleNode = getPreviousToMiddleNode(head, length); 
        prevToMiddleNode.next = prevToMiddleNode.next.next;
        return head;
    } 

    private int getLength(ListNode head) {
        int length = 0;
        ListNode ptr = head;
        while(ptr != null) {
            length++;
            ptr = ptr.next;
        }

        return length;
    }

    private ListNode getPreviousToMiddleNode(ListNode head, int n) {
        int middle = n/2;

        ListNode ptr = head;
        int count = 0;
        while(count < middle-1) {
            ptr = ptr.next;
            count++;
        }

        return ptr;
    }
}
