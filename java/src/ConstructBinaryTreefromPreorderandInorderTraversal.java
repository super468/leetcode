/**
 * Creator : wts
 * Date : 6/20/18
 * Title : 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Description :
 *
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 *
 * You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 *
 * preorder = [3,9,20,15,7]
 *
 * inorder = [9,3,15,20,7]
 *
 * Return the following binary tree:
 *
 *      3
 *     / \
 *    9  20
 *   / \
 * 15   7
 *
 *
 * Analysis :
 */

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int mid, int left, int right) {
        if(mid < 0 || mid > preorder.length || left < 0 || left > inorder.length || right < 0 || right > inorder.length ||
                left > right) return null;
        int i;
        for(i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[mid]){
                break;
            }
        }
        TreeNode node = new TreeNode(preorder[mid]);
        if(left == right) return node;
        node.left = helper(preorder, inorder, mid + 1, left, i - 1);
        node.right = helper(preorder, inorder, mid + (i - left) + 1, i + 1, right);
        return node;
    }
}
