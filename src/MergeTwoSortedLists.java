/**
 * Creator : wangtaishan
 * Date : 2018/8/25
 * Title : 21. Merge Two Sorted Lists
 * Description :
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * Analysis :
 *
 * nothing fancy
 *
 */

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode res = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                res.next = l1;
                l1 = l1.next;
                res = res.next;
            }
            else{
                res.next = l2;
                l2 = l2.next;
                res = res.next;
            }
        }
        if(l1 != null){
            res.next = l1;
        }
        else{
            res.next = l2;
        }
        return head.next;
    }
}
