/**
 * Creator : wts
 * Date : 6/21/18
 * Title : 35. Search Insert Posistion
 * Description :
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 *
 * Output: 2
 *
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 *
 * Output: 1
 *
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 *
 * Output: 4
 *
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 *
 * Output: 0
 *
 * Analysis : binary search 模板 注意最后target于start和end的比较
 */

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(target <= nums[start])
            return start;
        if(target <= nums[end])
            return end;

        return nums.length;
    }
}
