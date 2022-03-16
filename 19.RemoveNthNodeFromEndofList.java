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
        if(head == null){
            return null;
        }
        if(n < 0){
            return head;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        int index = 0;
        while(tmp.next != null){
            map.put(index, tmp.next);
            tmp = tmp.next;
            index++;
        }
        ListNode targetNode = map.get(index - n);
        if(index - n > 0){
            ListNode prevNode = map.get(index - n - 1);
            prevNode.next = targetNode.next;
        }else if(index - n == 0){
            dummy.next = targetNode.next;
        }
        return dummy.next;
    }
}
