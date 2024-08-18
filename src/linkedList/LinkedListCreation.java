package linkedList;
import linkedList.Node;

public class LinkedListCreation {

    public static Node createLinkedList(int[] ints) {
        Node head = new Node(ints[0]);
        Node curr = head;
        Node temp = null;
        for(int i = 1 ; i < ints.length;i++){
            temp = new Node(ints[i]);
            curr.next = temp;
            curr = curr.next;
        }
        temp.next = null;
        return head;
    }
}
