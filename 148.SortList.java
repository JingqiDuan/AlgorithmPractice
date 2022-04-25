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
    public ListNode sortList(ListNode head) {
        //head.next == null is necessary for exit
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode rightNode = mid.next;
        mid.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(rightNode);
        return merge(l1, l2);
    }


    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        //attention here
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
