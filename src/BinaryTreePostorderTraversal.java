import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Creator : wts
 * Date : 6/17/18
 * Title : 145. Binary Tree Postorder Traversal
 * Description : Given a binary tree, return the postorder traversal of its nodes' values.
 * Analysis :  http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html#3795455 这篇博客讲的很好
 * 
 * 但是作者对postorder的方法略复杂，postorder 和 preorder是类似的。
 * preorder是中左右，把code中所有的left换成right，就成了中右左，然后再用addFirst倒序保存，也就是左右中
 */

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        TreeNode current = root;
        while(current != null){
            if(current.right != null){
                TreeNode precede = current.right;
                while(precede.left != null && precede.left != current){
                    precede = precede.left;
                }

                if(precede.left == null){
                    list.addFirst(current.val);
                    precede.left = current;
                    current = current.right;
                }
                else{
                    precede.left = null;
                    //list.add(current.val);
                    current = current.left;
                }
            }
            else{
                list.addFirst(current.val);
                current = current.left;
            }
        }

        return list;
    }

    public List<Integer> postorderTraversalIteration(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.empty()){
            TreeNode top = stack.pop();
            if(top != null) list.addFirst(top.val); // 重要
            if(top.left != null) stack.push(top.left);
            if(top.right != null) stack.push(top.right);
        }
        return list;
    }
}
