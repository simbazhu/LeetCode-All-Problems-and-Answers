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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode end = head;
        ListNode newhead = head;
        ListNode newend = head;
        int listLength = 1;
        while(end.next != null){
            end = end.next;
            listLength++;
        }
        end.next = head;
        for(int i = 0; i < listLength - (k % listLength); i++){
            newend = newhead;
            newhead = newhead.next;   
        }
        newend.next = null;
        return newhead;
    }
}
