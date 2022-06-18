class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node tmp = new Node(insertVal);
            tmp.next = tmp;
            return tmp;
        }
        if(head.next == null){
            head.next = head;
            return head;
        }
        Node insertNode = new Node(insertVal);
        Node curNode = head;
        Node nextNode = head.next;
        while(nextNode != head){
            if(insertVal >= curNode.val && insertVal <= nextNode.val){
                break;
            }
            if(curNode.val > nextNode.val){
                if(insertVal >= curNode.val || insertVal <= nextNode.val){
                    break;
                }
            }
            curNode = curNode.next;
            nextNode = nextNode.next;
        }
        curNode.next = insertNode;
        insertNode.next = nextNode;
        return head;
    }
}
