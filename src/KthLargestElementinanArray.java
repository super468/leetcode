import com.apple.concurrent.Dispatch;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Creator : wts
 * Date : 6/23/18
 * Title : 215. Kth Largest Element in an Array
 * Description :
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 *
 * Output: 5
 *
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 *
 * Output: 4
 *
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * Analysis :
 *
 * Sort: O(N lg N) running time + O(1) memory
 *
 * PriorityQueue: O(N lg K) running time + O(K) memory  维护一个K大小的最小堆，每次插入值时 logK
 *
 * QuickSelect : O(N) worst O(N^2)
 *
 * T(N) = N + T(N/2) 时间复杂度期望 O(N)
 *
 * 每次根据 pivot，partition 两块，根据 k 决定舍掉哪块
 *
 */

class Sort {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class PriorityQeuue{
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int val : nums){
            q.offer(val);
            if(q.size() > k){
                q.poll();
            }
        }

        return q.peek();
    }
}

class QuickSelect{
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int tmp = partion(nums, lo, hi);
            if(tmp == nums.length - k)
                return nums[tmp];
            else if(tmp > nums.length - k)
                hi = tmp - 1;
            else lo = tmp + 1;
        }

        return nums[nums.length - k];
    }

    public int partion(int[] nums, int start, int end){
        int pivot = nums[end];
        int left = start;
        for(int i = start; i < end; i++){
            if(nums[i] <= pivot){
                swap(nums, left++, i); //put numbers < pivot to its left
            }
        }
        swap(nums, left, end);
        return left;
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}


