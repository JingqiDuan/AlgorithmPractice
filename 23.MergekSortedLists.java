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
    public ListNode mergeKLists(ListNode[] arr) {
      //use min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode node : arr){
            ListNode tmp = node;
            while(tmp != null){
                minHeap.offer(tmp.val);
                tmp = tmp.next;
            }
        }
        if(minHeap.size() == 0){
            return null;
        }
        ListNode results = new ListNode(minHeap.poll());
        ListNode answer = results;
        int size = minHeap.size();
        for(int i = 1; i < size + 1; i ++){
            results.next = new ListNode(minHeap.poll());
            results = results.next;
        }
        results.next = null;
        return answer;
    }
}
