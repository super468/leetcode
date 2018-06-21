/**
 * Creator : wts
 * Date : 6/21/18
 * Title : 69. Sqrt(x)
 * Description :
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 *
 * Output: 2
 *
 * Example 2:
 *
 * Input: 8
 *
 * Output: 2
 *
 * Explanation: The square root of 8 is 2.82842..., and since
 *
 * the decimal part is truncated, 2 is returned.
 * Analysis :
 */

public class SqrtX {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int start = 1;
        int end = x;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(x / mid == mid)
                return mid;
            else if(x / mid > mid)
                start = mid;
            else end = mid;
        }

        return start;
    }
}
