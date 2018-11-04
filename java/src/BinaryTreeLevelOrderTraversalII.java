import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Creator : wts
 * Date : 6/18/18
 * Title : 107. Binary Tree Level Order Traversal II
 * Description : Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * Analysis :
 */

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list;
        q.add(root);
        int curlevelnum;
        while(!q.isEmpty()){
            List<Integer> row = new ArrayList<>();
            curlevelnum = q.size();
            for(int i = 0; i < curlevelnum; i++){
                TreeNode p = q.remove();
                row.add(p.val);
                if(p.left != null) {
                    q.add(p.left);
                }
                if(p.right != null){
                    q.add(p.right);
                }
            }

            list.add(0, row);
        }
        return list;
    }
}
