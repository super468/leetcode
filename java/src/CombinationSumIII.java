import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/16/18
 * Title : 216. Combination Sum III
 * Description : Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 * Analysis : easy backtracking
 */

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<>();

        Backtracking(nums, k, n, list, row, 0, 0);
        return list;

    }

    public void Backtracking(int[] nums, int k, int n, List<List<Integer>> list, List<Integer> row, int presum, int index){
        if(row.size() == k && presum == n){
            list.add(row);
            return;
        }

        for(int i = index; i < nums.length; i++){
            row.add(nums[i]);
            List<Integer> copyrow = new ArrayList<>(row);
            Backtracking(nums, k, n, list, copyrow, presum + nums[i], i + 1);
            row.remove(row.size() - 1);
        }
    }
}
