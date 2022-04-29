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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode bigHead = new ListNode(0);
        ListNode smallHead = new ListNode(0);
        ListNode curBig = bigHead;
        ListNode curSmall = smallHead;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                curSmall.next = new ListNode(cur.val);
                curSmall = curSmall.next;
                cur = cur.next;
            }else{
                curBig.next = new ListNode(cur.val);
                curBig = curBig.next;
                cur = cur.next;
            }
        }
        curSmall.next = bigHead.next;
        return smallHead.next;
    }
}
