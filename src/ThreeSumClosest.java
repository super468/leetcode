import java.util.Arrays;

/**
 * Creator : wts
 * Date : 6/13/18
 * Title : 16. 3Sum Closest
 * Description :
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Analysis : 3sum的进阶版，只需要注意和target的距离要保持为绝对值
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums == null || nums.length < 3) return 0;
        int min = 500000;
        for(int i = 0;i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int k = nums.length - 1;
            for(int j = i + 1; j < k; j++){
                if(j > (i + 1) && nums[j] == nums[j - 1]) continue;
                int close = nums[j] + nums[k] + nums[i] - target;
                if(Math.abs(close) < Math.abs(min)){
                    min = close;
                }
                if(close > 0){
                    k--;
                    j--;
                }
                if(close == 0) return target;
            }
        }

        return target + min;
    }
}
