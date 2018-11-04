/**
 * Creator : wangtaishan
 * Date : 2018/9/1
 * Title : 617. Merge Two Binary Trees
 * Description :
 *
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 *
 *
 * Analysis :
 *
 *  merge t2 to t1, return t1
 *
 *  if t1 and t2 not null, t1.val = t1.val + t2.val
 *
 *  let t1's children be the node which is not null between t1 and t2.
 *
 *  if both are null, just let it be null and don't do anything.
 */

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if(t1 != null && t2 != null){
            t1.val = t1.val + t2.val;
            if(t1.left != null && t2.left != null)
                mergeTrees(t1.left, t2.left);
            else t1.left = t1.left != null ? t1.left : t2.left;
            if(t1.right != null && t2.right != null)
                mergeTrees(t1.right, t2.right);
            else t1.right = t1.right != null ? t1.right : t2.right;
        }

        return t1 != null ? t1 : t2;
    }

}
