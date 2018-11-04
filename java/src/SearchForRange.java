/**
 * Creator : wts
 * Date : 6/21/18
 * Title : 34. Search For Range
 * Description :
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 *
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 *
 * Output: [-1,-1]
 *
 * Analysis :
 *
 * OnceBinarySearch :
 * adding constrains when iterating, if nums[mid] == target move forward or backward the pointer
 * which is not equal to target.
 *
 * TwiceBinarySearch:
 * when nums[mid] == target, let start = mid, which can make 'start' be one of the last two target. so we can decide
 * right could be start or end if one of them is equal to target, otherwise return [-1, -1]
 *
 * let end = mid , it's the same.
 */

class OnceBinarySearch {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 1) return new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while(nums[start] < nums[end] && start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                if(nums[mid] > nums[start]) start++;
                if(nums[mid] < nums[end]) end--;
            }
            else if(nums[mid] > target){
                end = mid;
            } else start = mid;
        }

        if(nums[start] == nums[end] && nums[start] == target)
            return new int[]{start, end};
        else if(nums[start] ==  target)
            return new int[]{start,start};
        if(nums[end] == target){
            return new int[]{end, end};
        }
        else return new int[]{-1, -1};
    }
}

class TwiceBinarySearch{
    public int[] searchRange(int[] nums, int target) {
        if(nums.length < 1) return new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        int left = -1;
        int right = -1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target)
                end = mid;
            else
                start = mid;
        }
        if(nums[start] == target)
            left = start;
        else if(nums[end] == target)
            left = end;
        else return new int[]{-1, -1};

        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target)
                start = mid;
            else
                end = mid;
        }
        if(nums[end] == target)
            right = end;
        else if(nums[start] == target)
            right = start;
        else return new int[]{-1, -1};

        return new int[]{left, right};


    }
}
