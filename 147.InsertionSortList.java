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
 class Solution{
      public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode node = head;
        while(node != null){
            ListNode next = node.next;
            ListNode prevNode = dummy;
            ListNode sortNode = dummy.next;
            while(sortNode != null){
                if(node.val > sortNode.val){
                    prevNode = sortNode;
                    sortNode = sortNode.next;
                }else{
                    break;
                }
            }
            prevNode.next = node;
            node.next = sortNode;

            node = next;
        }
        return dummy.next;
    }
 }
