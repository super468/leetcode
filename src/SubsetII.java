import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/12/18
 * Title : 90. Subsets II
 * Description : Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Analysis : 给的数组中存在重复的数字， 比如 1 的 直接点分别是 2 和 2，由于1已经访问过第一个2，那么再访问第二个2的时候就会重复。需要过掉
 *
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */

public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        list.add(set);
        DFS(-1, nums, set, list);
        return list;
    }

    public void DFS(int r, int[] nums, List<Integer> set, List<List<Integer>> list){
        for(int i = r + 1; i < nums.length; i++){
            if(i > r + 1 && nums[i] == nums[i - 1]) continue; // skip duplicate
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
