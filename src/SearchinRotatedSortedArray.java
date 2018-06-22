/**
 * Creator : wts
 * Date : 6/22/18
 * Title : 33. Search in Rotated Sorted Array
 * Description :
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 *
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 *
 * Output: -1
 *
 * Analysis :
 *
 * 通过中间的数跟最左边的数比大小，来判断mid在哪块数组上，然后再用target mid end 三者 or target mid left 三者直接的关系来判断
 *
 * 有一种discuss是先用二分找到最小的点，然后再怎么做我就搞不懂了。
 */
class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums.length < 1) return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] > nums[mid]){
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
            return start;
        if(nums[end] == target)
            return end;

        return -1;
    }
}
