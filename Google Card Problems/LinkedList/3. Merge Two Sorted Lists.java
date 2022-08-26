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
        ListNode  dummy= new ListNode();
        ListNode head= dummy;
        int minVal = Integer.MIN_VALUE;
        while(list1 != null || list2 != null){
            int val1 = minVal, val2 = minVal;
            if(list1 != null){
                val1 = list1.val;
            }
            if(list2 != null){
                val2 = list2.val;
            }

            if((val1 != minVal && val1 <= val2) || val2 == minVal){
                dummy.next = list1;
                list1 = list1.next;
            }else if((val2 != minVal && val2 < val1) || val1 == minVal) {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        return head.next;
    }
}
