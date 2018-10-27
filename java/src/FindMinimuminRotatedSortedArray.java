/**
 * Creator : wts
 * Date : 6/23/18
 * Title : 153. Find Minimum in Rotated Sorted Array
 * Description :
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Analysis : binary search
 */

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length < 1) return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >nums[end])
                start = mid;
            else end = mid;
        }

        return nums[start] > nums[end] ? nums[end] : nums[start];
    }
}
