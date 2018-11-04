/**
 * Creator : wts
 * Date : 6/18/18
 * Title : 110. Balanced Binary Tree
 * Description : Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as:

 a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 * Analysis :
 * 第一种方法是调用height函数来算来访问当前节点的所有节点，O(N).isBalanced 函数遍历节点也是O(N)
 * time complexity 就是 O(N^2)
 *
 * 第二种方法是用DFS bottom up，height函数：如果左右子树相差超过1则返回 -1， 左右子树有一个 -1 也返回 -1。 左右子树都大于 -1，则返回
 * 两者最大 + 1。这种方法的巧妙在于它把boolean信息保存在 int。时间复杂度O(N)
 *
 */

public class BalancedBinaryTree {
    //time complexity O(N^2)
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        boolean flag;
        if(Math.abs(left - right) > 1) flag = false;
        else flag = true;
        return flag && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }


    //time complexity O(N)
    public boolean isBalancedDFS(TreeNode root) {
        if(height2(root) != -1) return true;
        else return false;
    }

    public int height2(TreeNode root){
        if(root == null) return 0;
        int left = height(root.left);
        if(left == -1)return -1;
        int right = height(root.right);
        if(right == -1) return -1;
        if(Math.abs(right - left) > 1) return -1;

        return 1 + Math.max(right, left);
    }


}


