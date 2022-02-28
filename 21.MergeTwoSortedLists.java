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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //use min heap
        PriorityQueue<Integer> heap =new PriorityQueue<>();
        while(list1 != null){
            heap.offer(list1.val);
            list1 = list1.next;
        }
        while(list2 != null){
            heap.offer(list2.val);
            list2 = list2.next;
        }
        if(heap.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(heap.poll());
        ListNode answer = head;
        while(!heap.isEmpty()){
            head.next = new ListNode(heap.poll());
            head = head.next;
        }
        head.next = null;
        return answer;
    }
}
