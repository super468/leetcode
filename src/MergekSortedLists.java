import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Creator : wangtaishan
 * Date : 2018/9/2
 * Title : 23. Merge k Sorted Lists
 * Description :
 *
 *Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * Analysis :
 *
 *      Using PriorityQueue datatype, it has many implementations. The most common one is binary heap.
 *
 *      the top element of the heap is the least number among the elements in heap.
 *
 *
 *      solution 2:
 *
 *      using the idea of merge sort. treat list as an element a number in original merge sort case.
 *
 *      //the time complexity is O(nlogk)
 *
 *      //n represents the total number of nodes
 *      //k represents the number of lists.
 *
 *       //T(k) = 2(k/2) + n;
 *
 */

public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,  new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2){
                return node1.val - node2.val;
            }
        });

        for(ListNode node : lists){
            if(node != null)
                queue.add(node);
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        while(!queue.isEmpty()){
            ListNode p_node = queue.poll();
            current.next = p_node;
            current = current.next;
            if(current.next != null)
                queue.add(current.next);
        }
        return head.next;
    }
}

class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1) return null;
        return partion(lists, 0, lists.length - 1);
    }

    public ListNode partion(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        if(left < right){
            int mid = (left + right) / 2;
            ListNode l_node = partion(lists, left, mid);
            ListNode r_node = partion(lists, mid + 1, right);
            return mergeList(l_node, r_node);
        }
        else return null;

    }

    public ListNode mergeList(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1.val < list2.val){
            list1.next = mergeList(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeList(list1, list2.next);
            return list2;
        }
    }

}