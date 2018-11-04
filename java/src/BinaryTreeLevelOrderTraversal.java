import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Creator : wts
 * Date : 6/18/18
 * Title : 102. Binary Tree Level Order Traversal
 * Description : Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * Analysis : BFS Using Queue.
 * 用一个curlevelnum 维护当前level的node数量。用一个队列装载node,当前level遍历完后，queue的size就是下一层的数量
 * TimeComplexity: O(N)
 * SpaceComplexity: O(N)
 */

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
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

            list.add(row);
        }
        return list;
    }
}
