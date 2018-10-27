/**
 * Creator : wts
 * Date : 6/22/18
 * Title : 81. Search in Rotated Sorted Array II
 * Description :
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 *
 * Output: false
 *
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 *
 * Would this affect the run-time complexity? How and why?
 *
 * Analysis :
 *
 * 这道题只有一种特殊情况需要考虑其他都和I是一样的
 *
 * 1 1 1 3 1
 *
 * 当左右和中间都相等时，只能左右各进一步
 *
 * worst O(N)
 */

public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length < 1) return false;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
            }else if(nums[start] > nums[mid]){
                if(nums[mid] < target && nums[end] >= target)
                    start = mid;
                else end = mid;
            }
            else{
                if(nums[mid] > target && nums[start] <= target)
                    end = mid;
                else start = mid;
            }
        }

        if(nums[start] == target)
            return true;
        if(nums[end] == target)
            return true;

        return false;
    }
}
