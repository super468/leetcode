import java.util.LinkedList;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/25/18
 * Title : 113. Path Sum II
 * Description :
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *          5
 *         / \
 *        4   8
 *       /   / \
 *      11  13  4
 *     /  \    / \
 *    7    2  5   1
 *
 *    Return:
 *    [
 *    [5,4,11,2],
 *    [5,8,4,5]
 *    ]
 *
 * Analysis :
 *
 * 这道题注意，backtracking的时候，我们不用在进入下一个结点的时候，就给他复制一个相同的row，而是可以在目标结束的时候，复制一个row.
 *
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        List<Integer> row = new LinkedList<>();
        DFS(root, list, row, 0, sum);
        return list;

    }

    public void DFS(TreeNode node, List<List<Integer>> list, List<Integer> row, int presum, int sum){
        if(node == null) return;
        row.add(node.val);
        if(node.val + presum == sum && node.left == null && node.right == null){
            list.add(new LinkedList<Integer>(row));
            row.remove(row.size() - 1);
            return;
        }
        else{
            DFS(node.left, list, row, presum + node.val, sum);
            DFS(node.right, list, row, presum + node.val, sum);
        }
        row.remove(row.size() - 1);

    }
}
