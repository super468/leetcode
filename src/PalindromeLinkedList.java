/**
 * Creator : wangtaishan
 * Date : 2018/9/1
 * Title : 234. Palindrome Linked List
 * Description :
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * Analysis :
 *
 *      using two pointers, one fast, one low to determine the middle of the linkedlist.
 *
 *      reverse the first half
 *
 *      compare the two halfs
 *
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;

        while(head != slow){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }

        head = pre;

        //odd number
        if(fast != null){
            slow = slow.next;
        }

        while(head != null){
            if(slow.val != head.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;

    }
}
