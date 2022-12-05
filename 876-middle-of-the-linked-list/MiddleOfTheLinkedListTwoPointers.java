class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return head;
        
        ListNode slowPtr = head, fastPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        
        return slowPtr;
    }
}
