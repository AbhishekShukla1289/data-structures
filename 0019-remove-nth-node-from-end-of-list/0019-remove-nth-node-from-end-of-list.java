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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tmp = dummy;

        //ListNode p = head;
        
        int count = 0;
        ListNode node = dummy;
        while(node != null && node.next != null){
            node = node.next;
            count++;
        }
        
        while((count - n) > 0){
            tmp = tmp.next;
            count--;
        }
        tmp.next = tmp.next.next;
        
        return dummy.next;
    }
}