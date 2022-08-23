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
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode result = new ListNode();
        addTwoNumbersHelper(l1, l2, 0, result);
        return result.next;
    }
    private void addTwoNumbersHelper(ListNode l1, ListNode l2,int carry, ListNode result) {
        if(l1 == null && l2 == null){ 
         if(carry == 1)
             result.next = new ListNode(carry);
            return;
        }
        
        if(l1 == null && l2 != null)
            l1 = new ListNode(0);

        if(l2 == null && l1 != null)
            l2 = new ListNode(0);

        int sum = l1.val +l2.val + carry;
        result.next = new ListNode(sum % 10);
        carry = sum/10;
        
        addTwoNumbersHelper(l1.next, l2.next, carry, result.next);
        
    }
}
