/**
 * Creator : wts
 * Date : 6/16/18
 * Title : 45. Jump Game II
 * Description :Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 *
 * Output: 2
 *
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 *
 * You can assume that you can always reach the last index.
 *
 * Analysis :  根据提示知道，至少有一条路可以到最后到index。我一开始用了lcs到dp方法，结果O(N*N)超时。
 *
 * 后来看分析，是用到贪心的算法，一段数组寻找最大的nums[i] + i 即最远的距离，这段数组结束在上一段数组最远能到达的位置。再以这个最远的距离作为
 * 下一组数组的起点，有几段数组就有几步。
 * 同样是O(N) Recursion 比Iteration 的慢好多
 */


/**
 * TLE O(N*N)
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;

        int[] minstep = new int[nums.length];
        for(int i = 0; i < minstep.length; i++){
            minstep[i] = Integer.MAX_VALUE;
        }

        return Recursion(nums, minstep, nums.length - 1);

    }

    public int Recursion(int[] nums, int[] minstep, int right){
        if(right == 0){
            minstep[right] = 0;
        }
        if(minstep[right] != Integer.MAX_VALUE) return minstep[right];
        for(int i = right - 1; i >=0; i--){
            if(nums[i] + i < right) continue;
            minstep[right] = Math.min(minstep[right], Recursion(nums, minstep, i) + 1);
        }
        return minstep[right];
    }
}

/**
 * Recursion
 */
class RecursionI{
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;
        return Recursion(nums, nums.length - 1);
    }

    public int Recursion(int[] nums, int right){
        if(right == 0) return 0;
        for(int i = 0; i < right; i++){
            if(nums[i] + i >= right){
                return 1 + Recursion(nums, i);
            }
        }

        return 1;
    }
}

/**
 * Greedy
 */

class Greeady{
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
