import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/17/18
 * Title : 145. Binary Tree Postorder Traversal
 * Description : Given a binary tree, return the postorder traversal of its nodes' values.
 * Analysis : to do
 */

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                current = current.right;
            }
            else{
                TreeNode pre = current.left;
                TreeNode tmp = pre;
                while(pre.right != null && pre.right != current){
                    if(pre.right == null){
                        pre.right = current;
                        current = current.left;
                    }
                    else{
                        pre.right = null;
                        reverse(tmp);
                        TreeNode start = pre;
                        while(start != null){
                            list.add(start.val);
                            start = start.right;
                        }
                        reverse(pre);
                        current = current.right;
                    }
                }
            }
        }

        return list;
    }

    // reverse from the end to start
    public TreeNode reverse(TreeNode start){
        TreeNode pre = null;
        TreeNode current = start;
        while(current != null){
            TreeNode p = current.right;
            current.right = pre;
            pre = current;
            current = p;
        }
        return pre;
    }
}
