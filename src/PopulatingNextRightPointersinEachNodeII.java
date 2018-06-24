/**
 * Creator : wts
 * Date : 6/24/18
 * Title : 117. Populating Next Right Pointers in Each Node II
 * Description :
 *
 * Given a binary tree
 *
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 *
 * You may only use constant extra space.
 *
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 *
 * Example:
 *
 * Given the following binary tree,
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 *4   5    7
 *
 * After calling your function, the tree should look like:
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 *
 * Analysis :
 *
 * 这道题和I 不同的地方在于，它不是一颗满二叉树，而是一颗普通的二叉树，所以当我们就不能单纯的将left结点链接到right结点上。
 *
 * 而是需要寻找在当前的level中最靠左的结点。
 *
 * 自己写到代码很丑陋，借鉴一下高赞答案的思路，利用 pre cur head 指针, clean efficient
 */

class StupidIteration {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode cur = root;
        TreeLinkNode head = null;

        while((head = nextNode(cur)) != null){
            //TreeLinkNode head = nextNode(cur);
            while(cur != null){

                if(cur.left != null){
                    if(cur.right != null) cur.left.next = cur.right;
                    else cur.left.next = nextNode(cur.next);
                }

                if(cur.right != null){
                    cur.right.next = nextNode(cur.next);
                }

                cur = cur.next;
            }
            cur = head;
        }
    }

    public TreeLinkNode nextNode(TreeLinkNode cur){
        if(cur == null) return null;
        while(cur != null){
            if(cur.left != null) return cur.left;
            if(cur.right != null) return cur.right;
            cur = cur.next;
        }

        return null;
    }
}

class ThreePointer{
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode cur = root;
        TreeLinkNode head = root; // the first node of this level
        TreeLinkNode pre = null; // the previous node of cur node

        while(cur != null){
            while(cur != null){
                if(cur.left != null){
                    if(pre != null){
                        pre.next = cur.left;
                    }
                    else{
                        head = cur.left;
                    }
                    pre = cur.left;
                }

                if(cur.right != null){
                    if(pre != null){
                        pre.next = cur.right;
                    }
                    else{
                        head = cur.right;
                    }
                    pre = cur.right;
                }

                cur = cur.next;
            }

            cur = head;
            pre = null;
            head = null;
        }
    }
}
