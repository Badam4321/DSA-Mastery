package linkedList;
import linkedList.Node;
import linkedList.LinkedListBasicOperations;
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2  = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        Node newHead =  reverseLinkedList(head);
        LinkedListBasicOperations.LinkedListTraversal(newHead);
    }

    static Node reverseLinkedList(Node head) {
        Node prev = null,curr = head,forw = null;
        while(curr != null){
            forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;

    }
}
