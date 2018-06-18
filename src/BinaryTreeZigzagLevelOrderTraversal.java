import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Creator : wts
 * Date : 6/18/18
 * Title : 103. Binary Tree Zigzag Level Order Traversal
 * Description : Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * Analysis : 跟levelorder一样，加一个height维护高度
 *
 */

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return list;
        q.add(root);
        int curlevelnum;
        int hight = 0;
        while(!q.isEmpty()){
            LinkedList<Integer> row = new LinkedList<>();
            curlevelnum = q.size();
            for(int i = 0; i < curlevelnum; i++){
                TreeNode p = q.remove();
                if(hight % 2 == 0) row.add(p.val);
                else row.addFirst(p.val);
                if(p.left != null) {
                    q.add(p.left);
                }
                if(p.right != null){
                    q.add(p.right);
                }
            }
            list.add(row);
            hight++;
        }
        return list;
    }
}

