/**
 * Creator : wangtaishan
 * Date : 2018/8/25
 * Title : 53. Maximum Subarray
 * Description :
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 * Analysis :
 *
 * the idea of the Kadane's Algorithm:
 *
 * find the diff between the elements. If the cur range sum goes below the cur point. Then reset the range by starting
 *
 * the point with cur. All these sum are locally optimal. So just record the max sum.
 *
 * the idea of dp:
 *
 * the subproblem is the maxsubarry(i) = item(i) + maxsubarray(i - 1) > 0 ? maxsubarray(i - 1) : 0
 *
 *
 */

public class MaximumSubarray {

    public int maxSubArray_kadane(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            cur = Math.max(nums[i], cur += nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    public int maxSubArray_dp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
