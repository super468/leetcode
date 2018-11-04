/**
 * Creator : wts
 * Date : 6/17/18
 * Title : 206. Reverse Linked List
 * Description : Reverse a singly linked list.
 *
 * Analysis : 单链表转置，一定要会！
 *
 */

/**
 * Iteration
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while(current != null){
            ListNode tmp = current.next;
            current.next = pre;
            pre = current;
            current = tmp;
        }

        return pre;
    }
}

/**
 * Recursion
 */

class ReverseRecursion{
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}


