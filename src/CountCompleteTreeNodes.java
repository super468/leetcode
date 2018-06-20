/**
 * Creator : wts
 * Date : 6/20/18
 * Title : 222. Count Complete Tree Nodes
 * Description :
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 *
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6

 * Analysis :
 *
 * 首先计算leftmost和rightmost的高度
 *
 * 如果rightmost和leftmost一样高，说明这棵树是full complete binary tree,那个node的数量就是2 ^ 高度 - 1
 *
 * 如果不是，就recursive计算左右字数的number, 再加上1(root)
 *
 * 总的来说，思想就是完全二叉树的子树也是一颗完全二叉树
 *
 */

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftmost = 0;
        int rightmost = 0;
        TreeNode l = root;
        while(l != null){
            l = l.left;
            leftmost++;
        }
        TreeNode r = root;
        while(r != null){
            r = r.right;
            rightmost++;
        }
        if(leftmost == rightmost) {
            int result = (int) Math.pow(2, leftmost);
            return result - 1;
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }
}
