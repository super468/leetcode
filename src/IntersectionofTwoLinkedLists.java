/**
 * Creator : wangtaishan
 * Date : 2018/9/1
 * Title : 160. Intersection of Two Linked Lists
 * Description :
 *
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * Analysis :
 *
 *      I have to see that I didn't come up with any solution, instead I check the discussion.
 *
 *      So fucking genius !
 *
 *      use two pointers to point the head of each list.
 *
 *      iterate those pointers together,
 *
 *      once one pointer reaches the end, set it to the another list's head.
 *
 *      until two pointers meet each other.
 *
 *      since the pointers runs the same length, they will meet in the intersection
 *
 *
 *      // another solution is to find the length of two lists. and align the pointers to the same starting point.
 *      //move them together until find an intersection or to the end and return null;
 */

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
