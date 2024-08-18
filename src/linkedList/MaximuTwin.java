package linkedList;
import linkedList.*;
public class MaximuTwin {
    public static void main(String[] args) {
        Node head = LinkedListCreation.createLinkedList(new int[]{47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,92,32,74,9,81,5,9});
        System.out.println(pairSum(head));
    }

    private static int pairSum(Node head) {
        Node slow = head , fast = head;
        int maximumTwin = Integer.MIN_VALUE;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = ReverseLinkedList.reverseLinkedList(slow);
        slow = head;
        while(fast != null){
            maximumTwin = Math.max(maximumTwin,slow.val + fast.val);
            slow = slow.next;
            fast = fast.next;
        }
        return maximumTwin;
    }
}
/*
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 */
