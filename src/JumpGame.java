/**
 * Creator : wts
 * Date : 6/15/18
 * Title : 55. Jump Game
 * Description :
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 *
 * Output: true
 *
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 *
 * Output: false
 *
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *
 * jump length is 0, which makes it impossible to reach the last index.
 *
 * Analysis :
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length < 1) return false;
        if(Recursion(nums, nums.length -1) >= nums.length - 1) return true;
        else return false;
    }

    public int Recursion(int[] nums, int right){
        if(right == 0) return nums[0];
        int step = Recursion(nums, right - 1);
        if(step < right) return Integer.MIN_VALUE;
        return Math.max(nums[right] + right, step);
    }
}
