import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/13/18
 * Title : 18. 4Sum
 * Description :Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
 *
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets
 *
 * Analysis : 跟3Sum 解法类似，只需要在外面再套一层循环，O(N^3)
 */

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if(nums == null || nums.length < 4) return list;
        for(int m = 0; m < nums.length - 3; m++){
            if(m > 0 && nums[m] == nums[m - 1]) continue; //防止 m 重复
            for(int i = m + 1;i < nums.length - 2; i++){
                if(i > m + 1 && nums[i] == nums[i - 1]) continue; // 防止 i 重复
                int k = nums.length - 1;
                int res = target - (nums[i]+nums[m]);
                for(int j = i + 1; j < k; j++){
                    if(j > (i + 1) && nums[j] == nums[j - 1]) continue; // 防止 j 重复，不需要 防止 k ，因为 j 在自增
                    int sum = nums[j] + nums[k];
                    if(sum == res){
                        List<Integer> set = Arrays.asList(nums[m],nums[i],nums[j],nums[k]);
                        list.add(set);
                    }
                    else if(sum > res){
                        k--;
                        j--;
                    }
                }
            }
        }

        return list;
    }
}
