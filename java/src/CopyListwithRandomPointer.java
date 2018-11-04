import java.util.HashMap;
import java.util.Map;

/**
 * Creator : wangtaishan
 * Date : 2018/8/28
 * Title : 138. Copy List with Random Pointer
 * Description :
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * Analysis :
 *
 *
 *
 */

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode copy = new RandomListNode(0);
        RandomListNode copyhead = copy;
        while(head != null){
            copy.next = map.getOrDefault(head, new RandomListNode(head.label));
            if(head.random != null){
                copy.next.random = map.getOrDefault(head.random, new RandomListNode(head.random.label));
            }
            head = head.next;
            copy = copy.next;
        }
        return copyhead.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
