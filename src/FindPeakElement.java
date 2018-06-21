/**
 * Creator : wts
 * Date : 6/21/18
 * Title : 162. Find Peak Element
 * Description :
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Analysis : Binary Search 当结束之后，start 和 end肯定有一个停在peak上，只需要比较他俩谁大就好
 */

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length < 2) return 0;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > nums[mid - 1]){
                if(nums[mid] > nums[mid + 1])
                    return mid;
                else
                    start = mid;
            }
            else{
                end = mid;
            }
        }
        if(nums[start] > nums[end])
            return start;
        if(nums[end] > nums[start])
            return end;

        return 0;
    }
}
