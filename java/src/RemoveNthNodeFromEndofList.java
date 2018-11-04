/**
 * Creator : wangtaishan
 * Date : 2018/8/25
 * Title : 19. Remove Nth Node From End of List
 * Description :
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 *
 * Analysis :
 *
 *  the solution of one pass is that you have the mark previsited node.
 *
 *  But how to and when to mark the the father node of the node which is gonna be deleted ?
 *
 *  You must wait the the distance between current point and mark point is n.
 *
 *  Then for this moment, the mark point is the node which is about to being deleted. And you already have its father
 *
 *  from last step. It's easy to do so.
 *
 *  Note if the deleted node is the first node. The father node would be null. Then just return the mark point's next node;
 *
 */

public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode point = head;
        ListNode father = null;
        ListNode tmp = head;

        int count = 0;

        if(head.next == null) return null;
        while(tmp != null){
            if(count < n){
                count++;
            }
            else{
                father = point;
                point = point.next;
            }
            tmp = tmp.next;
        }

        if(father == null){
            return point.next;
        }

        if(father != null && father.next != null){
            father.next = father.next.next;
        }

        return head;
    }
}
