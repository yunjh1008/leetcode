// 2. Add Two Numbers
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
        ListNode dummyHead = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = dummyHead;
        int carry = 0;
        
        while(p != null || q != null) {
            int num1 = (p != null) ? p.val : 0;
            int num2 = (q != null) ? q.val : 0;
            int sum = (num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;
            
            current.next = new ListNode(sum);
            current = current.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        
        if(carry != 0) {
            current.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
}
