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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode ans, curr1, curr2;

        if(list1.val<=list2.val){
            ans = list1;
            curr1 = ans.next;
            curr2=list2;
        }
        else{
            ans = list2;
            curr2 = ans.next;
            curr1=list1;
        }

        while (curr1!=null && curr2!=null) {
            if(curr1.val<=curr2.val){
                ans.next=curr1;
                curr1=curr1.next;
            }            
            else{
                ans.next=curr2;
                curr2=curr2.next;
            }
            ans=ans.next;
        }

        if(curr1==null){
            ans.next=curr2;
        }
        else{
            ans.next=curr1;
        }

        if(list1.val<=list2.val){
            return list1;
        }
        return list2;
    }
}