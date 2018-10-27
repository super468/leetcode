/**
 * Creator : wts
 * Date : 6/20/18
 * Title : 99. Recover Binary Search Tree
 * Description :
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Example 1:
 *
 * Input: [1,3,null,null,2]
 *
 *   1
 *  /
 * 3
 * \
 * 2
 *
 * Output: [3,1,null,null,2]
 *
 *   3
 *  /
 * 1
 *  \
 *   2
 *
 *   Example 2:
 *
 *   Input: [3,1,4,null,null,2]
 *     3
 *    / \
 *   1   4
 *  /
 * 2
 *
 *Output: [2,1,4,null,null,3]
 *
 *     2
 *    / \
 *   1   4
 *  /
 * 3
 *
 * Follow up:
 *
 * A solution using O(n) space is pretty straight forward.
 *
 * Could you devise a constant space solution?
 *
 * Analysis : 掌握 Morris 算法真的很重要，尤其对于二叉树空间复杂度为O(1)来说。
 *
 *  对于BST 相当于对其进行一次Morris遍历，找到其中两个位置相反的结点。
 *
 *  这里面的trick在于当我们维护一个 p 结点来做当前结点的前置结点。那么当 p.val > cur.val 时，哪个是第一个不对的点？
 *
 *  这里当第一次出现 p.val > cur.val 时 p 是第一个 出错的值。
 *
 *  第二次出现时， cur是第二个出现的值。
 *
 *  找到以后，直接交换两者的值即可
 */

class Morris {
    public void recoverTree(TreeNode root) {
        TreeNode left = null;
        TreeNode right = null;
        TreeNode pre = null;
        TreeNode p = null;
        TreeNode cur = root;
        while(cur != null){
            if(p != null && p.val >= cur.val){
                if(left == null) left = p;
                right = cur;
            }
            if(cur.left != null){
                pre = cur.left;
                while(pre.right != null && pre.right != cur){
                    pre = pre.right;
                }

                if(pre.right == null){
                    pre.right = cur;
                    cur = cur.left;
                }
                else{
                    pre.right = null;
                    p = cur;
                    cur = cur.right;
                }
            }
            else{
                p = cur;
                cur = cur.right;
            }
        }

        int val = left.val;
        left.val = right.val;
        right.val = val;

    }
}
