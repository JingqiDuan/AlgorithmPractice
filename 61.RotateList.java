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
        //stopped at tmp.next == null; start with 1;
        int length = 1;
        ListNode tmp = head;
        while(tmp.next != null){
            length++;
            tmp = tmp.next;
        }
        k %= length;
        if(k == 0){
            return head;
        }
        tmp.next = head;
        for(int i = 0; i < length - k; i++){
            tmp = tmp.next;
        }
        ListNode newHead = tmp.next;
        tmp.next = null;
        return newHead;
    }
}

/*
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
        if(head == null){
            return head;
        }
        int step = k % getLength(head);
        if(step == 0){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = pre.next;
        pre.next = reverse(start);
        start = pre.next;
        ListNode end = pre;
        for(int i = 0; i < step; i++){
            end = end.next;
        }
        ListNode nextNode = end.next;
        end.next = null;
        pre.next = reverse(start);
        start.next = reverse(nextNode);
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        return pre;
    }

    public int getLength(ListNode head){
        ListNode tmp = head;
        int count = 0;
        while(tmp != null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }
}
*/
