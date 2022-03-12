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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        while(tmp.next != null && tmp.next.next != null){
            if(tmp.next.val == tmp.next.next.val){
                int sameVal = tmp.next.val;
                //tmp.next is the node tmp pointing at
                while(tmp.next != null && sameVal == tmp.next.val){//tmp.next is updating
                    tmp.next = tmp.next.next;
                }
            }else{
                tmp = tmp.next;
            }
        }
        
        return dummy.next;
    }
}
