import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/13/18
 * Title : 46. Permutations
 * Description : Given a collection of distinct integers, return all possible permutations.
 * Analysis :  Backtracking
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<>();

        DFS(nums, list, set);

        return list;
    }

    public void DFS(int[] nums, List<List<Integer>> list, List<Integer> set){
        if(set.size() < nums.length){
            for(int i = 0; i < nums.length; i++){
                if(set.contains(nums[i])) continue; // skip elements already in set
                set.add(nums[i]);
                ArrayList<Integer> copyset = new ArrayList<Integer>(set);
                DFS(nums, list, copyset);
                set.remove(set.size() - 1);
            }
        }
        else{
            list.add(set);
        }
    }
}