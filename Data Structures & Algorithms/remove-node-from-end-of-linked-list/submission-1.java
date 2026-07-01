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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        ListNode reversed = reverseLinkedList(head);
        if(n==1){
            return reverseLinkedList(reversed.next);
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = reversed;
        ListNode h = dummy;
        int k=1;
        while (k!=n) {
            h = h.next;
            k++;
        }
        h.next = h.next.next;
        return reverseLinkedList(reversed);
    }

    public ListNode reverseLinkedList(ListNode h){
        ListNode prev = null;
        while (h!=null) {
            ListNode temp = h.next;
            h.next = prev;
            prev = h;
            h = temp;
        }
        return prev;
    }
}
