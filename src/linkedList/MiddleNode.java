package linkedList;
import linkedList.Node;
import linkedList.LinkedListCreation;
import linkedList.LinkedListBasicOperations;

public class MiddleNode {
    public static void main(String[] args) {
        Node head = LinkedListCreation.createLinkedList(new int[]{1,2,3,4,5});
        //LinkedListBasicOperations.LinkedListTraversal(head);
        head = middleOfLinkedList(head);
        LinkedListBasicOperations.LinkedListTraversal(head);

    }

    private static Node middleOfLinkedList(Node head) {
        Node slow = head , fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
