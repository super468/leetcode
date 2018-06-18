/**
 * Creator : wts
 * Date : 6/18/18
 * Title : 111. Minimum Depth of Binary Tree
 * Description : Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 * Analysis : 这里面的一个trick就是左或右子树为空是，其深度为0。但是我们并不想加一个0。
 *
 * 例如 下图的深度是2，而不是1
 *
 *     1
 *   /
 * 2
 */

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right != null) return 1 + minDepth(root.right);
        if(root.right == null && root.left != null) return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));

    }
}
