/**
 * Creator : wangtaishan
 * Date : 2018/8/23
 * Title : 9. Palindrome Number
 * Description :
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 *
 * Coud you solve it without converting the integer to a string?
 *
 * Analysis : 比较简洁的方法是从右边 reverse = reverse * 10 + x % 10;
 *
 *
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        else if(x < 10) return true;
        int a = x;
        int len = 0;
        while(a > 0){
            a = a / 10;
            len++;
        }
        int c = x;

        int i = 1;
        while(len > 1){
            int d = (int) Math.pow(10.0, (len - 1) * 1.0);
            int e = (int) Math.pow(10.0, 1 * 1.0);
            if(c / d != c % e)
                return false;
            c = c % d;
            c = c / e;
            len = len - 2;
            i++;
        }
        return true;

    }

    public boolean isPalindrome_logn(int x) {
        if (x < 0) {
            return false;
        }
        int y = x;
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return reverse == y;
    }


}
