import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/17/18
 * Title : 94. Binary Tree Inorder Traversal
 * Description : Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Analysis : Morris Traversal Time Complexity O(N) Space Complexity O(1)
 *
 * http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 *
 *
 */

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode current = root;
        while(current != null){
            if(current.left != null){
                TreeNode precede = current.left;
                while(precede.right != null && precede.right != current){
                    precede = precede.right;
                }

                if(precede.right == null){
                    precede.right = current;
                    current = current.left;
                }
                else{
                    precede.right = null;
                    list.add(current.val);
                    current = current.right;
                }
            }
            else{
                list.add(current.val);
                current = current.right;
            }
        }

        return list;
    }
}
