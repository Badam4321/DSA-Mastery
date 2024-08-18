package linkedList;

import linkedList.LinkedListCreation;
import linkedList.Node;
import linkedList.LinkedListBasicOperations;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Node head1 = LinkedListCreation.createLinkedList(new int[]{3,7,10});
        Node head2 = LinkedListCreation.createLinkedList(new int[]{1,2,5,8,10});
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
// Attach remaining nodes of head1 or head2
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        LinkedListBasicOperations.LinkedListTraversal(dummy.next);
    }
}
