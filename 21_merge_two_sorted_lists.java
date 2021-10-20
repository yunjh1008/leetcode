// 21. Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Prev. (fake) head node b/c need to store head node
        ListNode prevHead = new ListNode(-101);
        ListNode mergedList = prevHead;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                mergedList.next = l1;
                l1 = l1.next;
            }
            else {
                mergedList.next = l2;
                l2 = l2.next;
            }
            
            mergedList = mergedList.next;
        }
        
        // append remaining nodes
        if(l1 == null)
            mergedList.next = l2;
        else if(l2 == null)
            mergedList.next = l1;
        
        return prevHead.next;
    }
}
