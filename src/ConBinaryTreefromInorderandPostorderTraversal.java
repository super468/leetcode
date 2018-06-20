/**
 * Creator : wts
 * Date : 6/20/18
 * Title : 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Description :
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 *
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * inorder = [9,3,15,20,7]
 *
 * postorder = [9,15,7,20,3]
 *
 * Return the following binary tree:
 *
 *       3
 *     /  \
 *    9   20
 *   /  \
 * 15   7
 *
 * Analysis :  这道题需要用递归，重点在于利用poster的mid在数组的最后，用这个信息在inorder找到mid位置，来确定左右子树的大小，
 * 再反过来在poster数组里求各自的mid
 */

public class ConBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int mid, int left, int right) {
        if(mid < 0 || mid > postorder.length || left < 0 || left > inorder.length || right < 0 || right > inorder.length ||
                left > right) return null;
        int i;
        for(i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder[mid]){
                break;
            }
        }
        TreeNode node = new TreeNode(postorder[mid]);
        if(left == right) return node;
        node.right = helper(inorder, postorder, mid - 1, i + 1, right);
        node.left = helper(inorder, postorder, mid - (right - i) - 1, left, i - 1);
        return node;
    }
}
