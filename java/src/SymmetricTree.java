/**
 * Creator : wts
 * Date : 6/19/18
 * Title : 101. Symmetric Tree
 * Description :
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *    1
 *   / \
 *  2   2
 * / \ / \
 *3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
     1
    / \
   2   2
   \   \
   3    3

 Note:

 Bonus points if you could solve it both recursively and iteratively.
 * Analysis : Recursion: 需要比较两个节点是否相等，并比较其子节点。
 *            Iteration：用BFS，不是传统的将需要比较的节点的孩子依次入队
 *
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity : O(N)
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right){
        if(left == null && right != null) return false;
        if(right == null && left != null) return false;
        if(left == null && right == null) return true;
        if(left.val == right.val && compare(left.left, right.right) && compare(left.right, right.left)) return true;
        return false;
    }

    public boolean isSymmetricBFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
