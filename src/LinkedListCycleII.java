
/**
 * Creator : wts
 * Date : 6/11/18
 * Title : 142. Linked List Cycle II
 * Description : Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Analysis :
 *
 * 判断链表是否有环，只需要设置两个快慢指针就可以了
 *
 * 判断环的入口
 *     a            b
 *     A ------ B --------+
 *              |         |
 *            c |         |
 *              +-------- C



 * A: 起始点
 * B: Cycle Begins
 * C: 1st 快慢指针相遇点


 * A->B: a
 * B->C: b
 * C->B: c
 * 环的长度 (b+c) 为 R
 *
 * 第一次相遇时，慢指针所走步数为
 *
 * a + b
 *
 * 快指针走的步数为
 *
 * a + b + nR
 *
 * 我们知道快指针是慢指针速度的2倍，因此
 *
 * 2(a + b) = a + b + nR
 *
 * 那么
 *
 * a + b = nR
 *
 * 同时
 *
 * b + c = R
 *
 * 所以
 *
 * a = (n - 1)R + c;
 *
 * 也就是说，从A点和C点同时出发，以相同的速度前进，那么下一次相遇的位置将是B。
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}



public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, low;
        fast = head;
        low = head;

        if(head == null || head.next == null) return null;

        while(fast != null && low != null){

            if(fast.next == null) return null;
            fast = fast.next.next;
            low = low.next;
            // not fast.val == low.val
            if(fast == low) break;

        }

        if(fast != null && low != null){
            fast = head;
            while(fast != low){
                fast = fast.next;
                low = low.next;
            }
            return fast;
        }

        return null;
    }
}
