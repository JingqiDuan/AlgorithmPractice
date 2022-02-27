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
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }
        int theSize = arr.size();
        for(int i = 0; i < theSize / 2 ; i ++){
            if(arr.get(i) != arr.get(theSize - i -1)){
                return false;
            }
        }
        return true;
    }
}
