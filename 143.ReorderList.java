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
    public void reorderList(ListNode head) {
        ListNode mid = getMiddleNode(head);
        ListNode list1 = head;
        ListNode list2 = mid.next;
        mid.next = null;
        list2 = reverse(list2);
        merge(list1, list2);
    }

    public ListNode getMiddleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public void merge(ListNode head1, ListNode head2){
        while(head1 != null && head2 != null){
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head1.next = head2;
            head1 = tmp1;

            head2.next = head1;
            head2 = tmp2;
        }
    }


    /*public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            list.add(tmp);
            tmp = tmp.next;
        }
        int i = 0;
        int j = list.size() - 1;
        while(i < j){
            list.get(i).next = list.get(j);
            i++;
            if(i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }*/
}
