import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/13/18
 * Title : 15. 3Sum
 * Description : Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Analysis : 3sum问题，我首先想到的是用dfs，结果复杂度O(2^N)太高。两种方法：一种是hashmap，一种是two pointer
 *
 * 重点讲two pointer： 解决2sum问题，可以采用two pointer的方式，左右各一个pointer。
 *
 * 两者之和大于target，right pointer向左移动。反之，left pointer向右。
 *
 * 注意不能有重复set出现
 *
 */

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums == null || nums.length < 3) return list;
        for(int i = 0;i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue; // 防止 i 重复
            int k = nums.length - 1;
            int res = -nums[i];
            for(int j = i + 1; j < k; j++){
                if(j > (i + 1) && nums[j] == nums[j - 1]) continue; // 防止 j 重复，不需要 防止 k ，因为 j 在自增
                int sum = nums[j] + nums[k];
                if(sum == res){
                    List<Integer> set = Arrays.asList(nums[i],nums[j],nums[k]);
                    list.add(set);
                }
                else if(sum > res){
                    k--;
                    j--;
                }
            }
        }

        return list;

    }
}
