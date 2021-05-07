// using Slow and Fast pointers algorithm -> this used to get the middle value of linkedlist  
// if it is an array, we will get middle using indices directly
// complextity O(nlogn)

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
      if(head == null) return null;
        
       return buildBST(head, null);
    }
    
    public TreeNode buildBST(ListNode start, ListNode end){
        
        if(start == end) return null;

//         to get the middle val of linkedList using slow and fast pointers
        ListNode slow=start;
        ListNode fast=start;
        while(fast.next != end && fast.next.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // System.out.println(slow.val);
        TreeNode node =new TreeNode(slow.val);
        node.left = buildBST(start, slow);
        node.right = buildBST(slow.next, end);
        return node;
    }
}
