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
    public int count;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sizeOfList = calculateSize(head);

        int targetIndex = sizeOfList - n ;
        int currentIndex = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;

        while(currentIndex++ <  targetIndex){
            first = first.next;
        }
        
        first.next = first.next.next;
        return dummy.next;
    }
    
    private int calculateSize(ListNode head){
        int size=0;
        while(head != null){
            head = head.next;
            size++;
        }
        return size;
    }
}
