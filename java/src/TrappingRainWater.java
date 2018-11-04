/**
 * Creator : wangtaishan
 * Date : 2018/8/29
 * Title : 42. Trapping Rain Water
 * Description :
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 *
 * Output: 6
 *
 * Analysis :
 *
 *
 *
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int left = 0;
        int right = height.length - 1;
        int leftmax = height[0];
        int rightmax = height[height.length - 1];
        int water = 0;
        while(left <= right){
            if(leftmax < rightmax){
                leftmax = Math.max(height[left], leftmax);
                water += leftmax - height[left];
                left++;
            }
            else{
                rightmax = Math.max(height[right], rightmax);
                water += rightmax - height[right];
                right--;
            }
        }
        return water;
    }
}
