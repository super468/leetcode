/**
 * 78 题目：给一组数组，找到其所有的subset。
 *
 *   Input: nums = [1,2,3]
     Output:
     [
     [3],
     [1],
     [2],
     [1,2,3],
     [1,3],
     [2,3],
     [1,2],
     []
     ]
 *
 * 分析：九章算法上讲过的一题，用的是DFS。
 *                  []
 *                   |
 *          [1]     [2]    [3]
 *          |        |
 *     [1,2] [1,3] [2,3]
 *       |
 *    [1,2,3]
 *
 *      需要注意的是，对subset的深拷贝。
 *
 */


import java.util.ArrayList;
import java.util.List;

/**
 * DFS solution
 */
class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        list.add(set);
        DFS(-1, nums, set, list);
        return list;
    }

    public void DFS(int r, int[] nums, List<Integer> set, List<List<Integer>> list){
        for(int i = r + 1; i < nums.length; i++){
            set.add(nums[i]);
            //copy
            List<Integer> copyset = new ArrayList<Integer>(set);
            //add
            list.add(copyset);
            DFS(i, nums, copyset, list);
            //backtracking
            set.remove(set.size() - 1);
        }
    }
}

/**
 *  InterationSolution
 *
 *  discussion中更简单的方法
 *
 *  思想我觉得可以理解为 解决subproblem
 *
 *  [1,2,3]的subset 可以看成是，包含 3 的 subset 和 不包含 3 的 subset
 *
 *  那包含 3 的 subset 就可以看作是每个不包含 3 的 subset 加上 3
 *
 *  那不包含 3 的 subset 就是 只包含 1，2 的 subset 和 []
 *
 *  那就把问题简化为求 [1,2] 的 subset
 *
 *
 */
class IterationSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int n : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}