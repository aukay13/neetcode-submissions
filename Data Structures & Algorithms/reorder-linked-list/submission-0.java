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
    public void reorderList(ListNode head) {
        if(head.next==null){
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second!=null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        second = prev;
        ListNode temp1, temp2;
        while (head!=null) {
            temp1 = head.next;
            temp2 = second.next;
            head.next = second;
            if(temp1==null && temp2!=null){
                break;
            }
            second.next = temp1;
            head = temp1;
            second = temp2;
        }
    }
}
