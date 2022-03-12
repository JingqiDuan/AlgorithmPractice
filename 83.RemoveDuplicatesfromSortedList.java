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
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        set.add(tmp.next.val);
        while(tmp.next != null && tmp.next.next != null){
            ListNode prev = tmp.next;
            ListNode cur = tmp.next.next;
            if(!set.contains(cur.val)){
                set.add(cur.val);
                tmp = tmp.next;
            }else{
                prev.next = cur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
