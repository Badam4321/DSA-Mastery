package linkedList;
import linkedList.Node;
public class LinkedListBasicOperations {
    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        LinkedListTraversal(head);
        //Lets see how to insert an element [noe] into linked list
        int pos = 2;
        insertItemInLinkedList(15, head , pos);
        LinkedListTraversal(head);
        //Lets delete an element in a Linked list
        deleteItemInLinkedList(head,2);
        LinkedListTraversal(head);
        System.out.println(LengthOfLinkedList(head));


    }

    private static int LengthOfLinkedList(Node head) {
        int count = 0;
        Node curr = head;
        while(curr != null){
            count ++;
            curr = curr.next;
        }
        return count;
    }

    private static void deleteItemInLinkedList(Node head, int pos) {
        if(head == null){
            return;
        }
        if(pos == 0){
            head = head.next;
            return;
        }
        Node prev = head;
        for(int i = 0 ; i < pos - 1 ; i++) prev = prev.next;
        prev.next = prev.next.next;
    }

    private static void insertItemInLinkedList(int value, Node head, int pos) {
        Node temp = new Node(value);
        if(pos == 0){
            temp.next = head;
            head = temp;
            return;
        }
        Node prev = head;
        for(int i = 0; i < (pos - 1) ; i++){
            prev = prev.next;
        }
        temp.next = prev.next;
        prev.next = temp;

    }

    static void LinkedListTraversal(Node head) {
        Node curr = head;
        while(curr != null){
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
