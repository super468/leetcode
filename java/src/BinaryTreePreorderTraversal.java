import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Creator : wts
 * Date : 6/17/18
 * Title : 144. Binary Tree Preorder Traversal
 * Description : Given a binary tree, return the preorder traversal of its nodes' values.
 * Analysis : preorder: root left right
 * 重点考虑iteration 和 Morris。关于 Morris 看 http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 */

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        if(root == null) return list;
        while(!stack.empty()){
            TreeNode parent = stack.pop();
            list.add(parent.val);
            if(parent.right != null) stack.push(parent.right);
            if(parent.left != null)stack.push(parent.left);
        }
        return list;
    }
}

class RecursionSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            helper(root.left, list);
            helper(root.right, list);
        }

    }

}

class MorrisTraversal{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode current = root;
        while(current != null){
            if(current.left != null){
                TreeNode precede = current.left;
                while(precede.right != null && precede.right != current){
                    precede = precede.right;
                }

                if(precede.right == null){
                    list.add(current.val);
                    precede.right = current;
                    current = current.left;
                }
                else{
                    precede.right = null;
                    //list.add(current.val);
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



 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
