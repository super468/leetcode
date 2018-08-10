import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Creator : wts
 * Date : 6/15/18
 * Title : 47. Permutations II
 * Description :  Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 *
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * Analysis :  这道题在数组中加了duplicate，那么以后这种加duplicate的题想要去重就要排序！
 *
 * 第二点是这道题本来通用解法是backtracking，但是以后一定要每道题都要先思考是不是有recursion的解法，就是寻找subproblem
 *
 * 这道题可以看成是[1,1,2] = 求 [1,1,2] + [1,1,2](去重) + [2,1,1]。 将每个元素都作为第一个元素求其剩下的数组的排列。
 *
 * 注意这里一定要排序，要保证后面数组里的元素不会等于之前换过的元素。
 *
 *
 *
 *
 * */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        DFS(nums, list, map);
        return list;
    }

    public void DFS(int[] nums, List<List<Integer>> list, LinkedHashMap<Integer,Integer> map){
        if(map.size() < nums.length){
            for(int i = 0; i < nums.length; i++){
                if(map.containsKey(i) || i > 0 && nums[i] == nums[i - 1] && !map.containsKey(i - 1)) continue; // 重点！！
                map.put(i, nums[i]);
                LinkedHashMap<Integer,Integer> copymap = new LinkedHashMap<Integer,Integer>(map);
                DFS(nums, list, copymap);
                map.remove(i);
            }
        }
        else{
            list.add(new ArrayList<Integer>(map.values()));
        }
    }
}



class PermutationRecursion{
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // 排序！！
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Recursion(nums, list, 0, nums.length);
        return list;
    }

    public void Recursion(int[] nums, List<List<Integer>> list, int i, int j){
        if(i == j - 1){
            list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));  //int array 转 list 方法
            return;
        }

        for(int k = i; k < j; k++){
            if(k > i && nums[i] == nums[k]) continue;
            int tmp;
            tmp = nums[k];
            nums[k] = nums[i];
            nums[i] = tmp;
            int[] copynums = nums.clone();
            Recursion(copynums, list, i + 1, j);
        }
    }
}
