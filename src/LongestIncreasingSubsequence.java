/**
 * Creator : wts
 * Date : 6/24/18
 * Title : 300. Longest Increasing Subsequence
 * Description :
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 *
 * Output: 4
 *
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * Analysis :
 *
 * 普通DP时间复杂度是 O(N^2)
 *
 * 其中将i前面的元素的dp值一一比较是比较没有必要的，我们可以维护一个last_min[k] 的数组，用来存储长度为k的lis的末尾值的最小值。
 *
 * 我们只需要找到 nums[i] > last_min[j] 即可。
 *
 * last_min是一个有序的数组.
 *
 * 理由，由定义last_min[i]表示长度为i的序列A的最后一个元素的值，last_min[i-1]表示长度为i-1的序列B的最后一个元素的值，那么last_min[i-1]<last[i]；
 *
 * 否则序列A的前i-1个元素构成的序列便可替代序列B。所以last_min是有序的.
 *
 * 有序的话就可用 binary search
 *
 * 所以最后的时间复杂度为 O(NlogN)
 *
 */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 1) return 0;
        int[] last_min = new int[nums.length + 1];
        int max_len = 1;
        last_min[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int index = binarysearch(last_min, 0, max_len, nums[i]);
            last_min[++index] = nums[i];
            max_len = Math.max(max_len, index);
        }
        return max_len;

    }

    public int binarysearch(int[] nums, int start, int end, int target){
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target)
                end = mid;
            else start = mid;
        }
        if(target > nums[end])
            return end;
        if(target <= nums[start])
            return start - 1;
        return start;
    }
}
