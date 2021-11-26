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
    public ListNode reverseList(ListNode head) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        ListNode current = head;
        while(current != null) {
            list.add(current.val);
            current = current.next;
        }
        
        current = head;
        while(current != null) {
            current.val = list.getLast();
            list.removeLast();
            current = current.next;
        }
        
        return head;
    }
}
