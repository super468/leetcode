/**
 * Creator : wts
 * Date : 6/19/18
 * Title : 114. Flatten Binary Tree to Linked List
 * Description : Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *      1
 *     / \
 *    2   5
 *   / \   \
 *  3   4   6
 *
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * Analysis :  这道题说是用in place 就不能用额外的空间。
 *
 * 可以使用线索二叉树的方法，
 *
 * 寻找当前节点的中序遍历的前驱节点 p
 *  let right child of p be cur. right
 *  cur.right = cur.left;
 *  cur.left = null;
 *
 *  let cur be its original left child
 *
 */

public class FlattenBinaryTreetoLinkedList {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flattenMorris(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode cur){
        while(cur != null){
            if(cur.left != null){
                TreeNode p = cur.left;
                while(p.right != null){
                    p = p.right;
                }

                if(p.right == null){
                    p.right = cur.right;
                    cur.right = cur.left;
                    TreeNode t = cur;
                    cur = cur.left;
                    t.left = null;
                }

            }
            else{
                cur = cur.right;
            }
        }
    }
}
