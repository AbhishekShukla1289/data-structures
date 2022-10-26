/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode tmp = headA;
        while(tmp != null){
            lenA++;
            tmp = tmp.next;
        }
        tmp = headB;
        while(tmp != null){
            lenB++;
            tmp = tmp.next;
        }
        int count = Math.abs(lenB - lenA);
        
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}