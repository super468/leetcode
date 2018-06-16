import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/16/18
 * Title : 77. Combinations
 * Description : Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Analysis : backtracking
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        if(n < 1 || k < 1) {
            list.add(row);
            return list;
        }
        Backtracking(n, k, list, row, 1);
        return list;
    }

    public void Backtracking(int n, int k, List<List<Integer>> list, List<Integer> row, int start){
        if(row.size() == k){
            list.add(row);
            return;
        }

        for(int i = start; i <= n; i++){
            row.add(i);
            List<Integer> copyrow = new ArrayList<Integer>(row);
            Backtracking(n, k, list, copyrow, i + 1);
            row.remove(row.size() - 1);
        }
    }
}
