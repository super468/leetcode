import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/12/18
 * Title : 39. Combination Sum
 * Description : Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Analysis : 先排下序然后再用DFS backtraking
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        Arrays.sort(candidates);

        DFS(candidates, target, list, row, 0, 0);

        return list;

    }

    public void DFS(int[] candidates, int target, List<List<Integer>> list, List<Integer> row, int next, int presum){

        for(int i = next; i < candidates.length; i++){
            if(presum + candidates[i] == target){
                row.add(candidates[i]);
                //list.add(row);
                list.add(new ArrayList<Integer>(row));
                row.remove(row.size() - 1);
                break;
            }
            else if((presum + candidates[i]) < target){
                row.add(candidates[i]);
                //ArrayList<Integer> copyrow = new ArrayList<Integer>(row);
                DFS(candidates, target, list, row, i, presum + candidates[i]);
                row.remove(row.size() - 1);

            }
        }
    }

}
