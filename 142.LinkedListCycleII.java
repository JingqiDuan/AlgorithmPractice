/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        while(tmp != null){
            if(set.contains(tmp)){
                return tmp;
            }
            set.add(tmp);
            tmp = tmp.next;
        } 
        return tmp;
    }
}
