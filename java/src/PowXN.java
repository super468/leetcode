/**
 * Creator : wts
 * Date : 6/21/18
 * Title : 50. Pow(x, n)
 * Description : Implement pow(x, n), which calculates x raised to the power n (xn).
 * Analysis :
 *
 * 这道题用 binary search 时间复杂度是 O(N)
 *
 * 同过对底数的不断的平方，通过log(N)次即可将指数变为N
 *
 * 注意栈溢出的情况
 *
 * Note to prevent Overflow
 //one corner case is when n = Integer_MIN_VALUE = -2^31, which is -2147483648
 //whereas MAX_VALUE = 2^31-1, which is 1 less than abs(MIN_VALUE);
 //Since when n<0, let's say myPow(2,-2), we will convert it as x=1/x and n=-n, which is myPow(1/2,2);
 //when we let n=-n and n=MIN_VALUE, it will cost stackOverFlow, hence we need to manually change MIN_VALUE to MAX_VALUE
 */


class DisscuionAns{
    public double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            x = 1/x;
            return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}