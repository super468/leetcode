import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Creator : wts
 * Date : 6/24/18
 * Title : 199. Binary Tree Right Side View
 * Description :
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 *
 * Output: [1, 3, 4]
 *
 * Explanation:
 *
 *       1            <---
 *     /   \
 *    2     3         <---
 *    \     \
 *     5     4       <---
 * Analysis :
 *
 * 两种方法 DFS 和 BFS 都是 O(N)
 */

class BFS {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        q.offer(root);
        while(!q.isEmpty()){
            int cur = q.size();
            for(int i = 0; i < cur; i++){
                TreeNode p = q.poll();
                if(p.left != null) q.offer(p.left);
                if(p.right != null) q.offer(p.right);
                if(i == cur - 1)
                    list.add(p.val);
            }
        }

        return list;

    }
}

class DFS{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;

        Recursion(root, 1, list);

        return list;

    }

    public void Recursion(TreeNode cur, int dep, List<Integer> list){
        if(cur == null) return;
        if(dep > list.size()){
            list.add(cur.val);
        }

        Recursion(cur.right, dep + 1, list);
        Recursion(cur.left, dep + 1, list);
    }
}
