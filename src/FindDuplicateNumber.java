/**
 * 题目：287. Find the Duplicate Number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * 分析：
 *
 * 第一种方法：考虑到这是个1 -> N 的数组，N + 1 个元素。 那么某个元素的值就是数组中某个元素的索引。通过对元素和索引的转化，将索引和元素串起来。
 * 通过给元素设置负值，就可以表示访问到该元素，下次访问时如果还是负值就说明重复。
 *
 * 第二张方法：把索引和元素连起来看作是一个链表，而且这个链表必有环。 那么就可以利用Linked List Cycle的方法，来判断环的入口， 入口即为重复值。
 * 设置两个快慢指针，在两者相遇后，快指针回到原点和慢指针同速度，两者再次相遇的点就是环的入口。
 *
 *
 *
 *
 *
 */


class Solution1 {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])] < 0) return Math.abs(nums[i]);
            nums[Math.abs(nums[i])] *= -1;
        }
        return -1;
    }
}

class TwoPointer{

    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int low = nums[0];

        do{
            fast = nums[nums[fast]];
            low = nums[low];
        }while(fast != low);

        fast = nums[0];
        while (fast != low){
            fast = nums[fast];
            low = nums[low];
        }

        return fast;

    }

}
