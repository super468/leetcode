import java.util.ArrayList;

/**
 * Creator : wts
 * Date : 6/19/18
 * Title : 98. ValidateBinarySearchTree
 * Description :
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 *
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 *
 * Both the left and right subtrees must also be binary search trees.

 * Analysis :
 */

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Inorder(root, list);
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) >= list.get(i + 1))return false;
        }
        return true;
    }

    public void Inorder(TreeNode node, ArrayList<Integer> list){
        if(node == null) return;
        Inorder(node.left, list);
        list.add(node.val);
        Inorder(node.right, list);
    }
}
