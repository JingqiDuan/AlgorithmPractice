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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode cur1 = l1;
        while(cur1 != null){
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        ListNode cur2 = l2;
        while(cur2 != null){
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int total = a + b + carry;
            int nodeVal = total % 10;
            carry = total / 10;
            ListNode cur = new ListNode(nodeVal);
            cur.next = ans;
            ans = cur;
        }
        
        return ans;
    }
}
