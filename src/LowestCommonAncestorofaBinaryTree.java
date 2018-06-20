/**
 * Creator : wts
 * Date : 6/20/18
 * Title : 236. Lowest Common Ancestor of a Binary Tree
 * Description :
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *          _______3______
 *         /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *   6      _2       0       8
 *  /  \
 *  7   4
 *
 *  Example 1:
 *
 *  Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 *
 *  Output: 3
 *
 *  Explanation: The LCA of of nodes 5 and 1 is 3.
 *
 *  Example 2:
 *
 *  Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 *
 *  Ωutput: 5
 *
 *  Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
 *
 *  according to the LCA definition.
 *
 *  Note:
 *
 *  All of the nodes' values will be unique.
 *
 *  p and q are different and both values will exist in the binary tree.
 *
 *  Analysis : 主要用Recursion方法，
 *
 *  如果左子树返回值，右子树为null，则至少有一个值在左子树，返回左子树
 *
 *  如果两个子树都有值，则当前节点即为ancestor
 *
 *  如果两个子树都为空，则当前节点不包含值
 *
 *
 *
 *
 *
 */

class Recursion {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode r = helper(root.right, p, q);
        TreeNode l = helper(root.left, p, q);
        if(r != null && l != null) return root;
        if(r == null && l != null) return l;
        if(l == null && r != null) return r;
        if(l == null && r == null) return null;
        return null;
    }
}
