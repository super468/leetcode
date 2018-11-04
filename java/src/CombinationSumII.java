/**
 * Creator : wts
 * Date : 6/12/18
 * Title : 40. Combination SumII
 * Description :
 * Analysis :
 */
import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        Arrays.sort(candidates);

        DFS(candidates, target, list, row, 0, 0);

        return list;

    }

    public void DFS(int[] candidates, int target, List<List<Integer>> list, List<Integer> row, int next, int presum){
        Set<Integer> set = new HashSet<>();
        for(int i = next; i < candidates.length; i++){
            if(set.contains(candidates[i])) continue;
            else set.add(candidates[i]);
            if(presum + candidates[i] == target){
                row.add(candidates[i]);
                list.add(row);
                break;
            }
            else if((presum + candidates[i]) < target){
                row.add(candidates[i]);
                ArrayList<Integer> copyrow = new ArrayList<Integer>(row);
                DFS(candidates, target, list, copyrow, i + 1, presum + candidates[i]);
                row.remove(row.size() - 1);

            }
        }
    }
}
