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
    public ListNode insertionSortList(ListNode head) {

        ListNode pseudoHead = new ListNode();
        ListNode curr = head, prevNode, nextNode;

        while (curr != null) {
            // At each iteration, we insert an element into the resulting list.
            prevNode = pseudoHead;
            nextNode = pseudoHead.next;

            // find the position to insert the current node
            while (nextNode != null) {
                if (curr.val < nextNode.val)
                    break;
                prevNode = nextNode;
                nextNode = nextNode.next;
            }
            ListNode nextIter = curr.next;
            // insert the current node to the new list
            curr.next = nextNode;
            prevNode.next = curr;

            // moving on to the next iteration
            curr = nextIter;
        }

        return pseudoHead.next;
    }
}
