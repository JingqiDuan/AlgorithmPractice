class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode oddHead = head.next;
        ListNode even = head;
        ListNode odd = oddHead;
        while(odd != null && odd.next != null){
            even.next = odd.next;
            even = even.next;
            odd.next = even.next;
            odd = odd.next;
        }
        even.next = oddHead;
        return head;
    }
}

/*
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode tmp = head;
        ListNode preEven = new ListNode(0);
        ListNode even = preEven;
        ListNode preOdd = new ListNode(0);
        ListNode odd = preOdd;
        boolean isEven = true;
        while(tmp != null){
            if(isEven){
                even.next = new ListNode(tmp.val);
                isEven = !isEven;
                even = even.next;
            }else{
                odd.next = new ListNode(tmp.val);
                isEven = !isEven;
                odd = odd.next;
            }
            tmp = tmp.next;
        }
        even.next = preOdd.next;
        return preEven.next;
    }
}
*/
