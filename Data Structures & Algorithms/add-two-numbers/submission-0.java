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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (l1!=null || l2!=null) {
            int a=0,b=0;
            if(l1!=null){
                a = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a+b+carry;
            int val = sum%10;
            carry = sum/10;
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
