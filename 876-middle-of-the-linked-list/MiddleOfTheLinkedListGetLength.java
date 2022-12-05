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
    public ListNode middleNode(ListNode head) {
        if(head == null) return head;
        
        int length = getLength(head);
        int halfLen = length / 2;
        
        ListNode ptr = head;
        while(ptr != null && halfLen > 0) {
            halfLen--;
            ptr = ptr.next;
        }
        
        return ptr;
    }
    
    private int getLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        
        while(temp != null) {
            temp = temp.next;
            length++;
        }
        
        return length;
    }
}
