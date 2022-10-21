/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // no node to be deleted
        if(node == null) {
            return;
        }

        ListNode curr = node;
        ListNode nextNode = curr.next;
        curr.val = nextNode.val;
        curr.next = nextNode.next;
        nextNode.next = null;
    }
}
