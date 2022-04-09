class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0; i < left - 1; i++){
            prev = prev.next;
        }
        head = prev.next;
        for(int i = left; i < right; i++){
            ListNode nextNode = head.next;
            head.next = nextNode.next;
            // wrong nextNode.next = head;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return dummy.next;
    }
    /*public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for(int i = 0; i < left - 1; i++){
            prev = prev.next;
        }
        ListNode rightNode = prev;
        for(int i = 0; i < right - left + 1; i++){
            rightNode = rightNode.next;
        }
        ListNode leftNode = prev.next;
        ListNode rightNext = rightNode.next;
        //break list
        prev.next = null;
        rightNode.next = null;
        reverseList(leftNode);
        //reconnect list
        prev.next = rightNode;
        leftNode.next = rightNext;
        return dummy.next;
    }
    public void reverseList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
    }*/
}
