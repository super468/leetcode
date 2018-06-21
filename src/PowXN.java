/**
 * Creator : wts
 * Date : 6/21/18
 * Title : 50. Pow(x, n)
 * Description : Implement pow(x, n), which calculates x raised to the power n (xn).
 * Analysis :
 */

public class PowXN {
    public double myPow(double x, int n) {

        if(x == 0) return 0;
        if(x == 1) return 1;
        if(n == 0) return 1;
        if(n == 1) return x;

        int pow = 1;
        double tmp = x;
        boolean flag = false;
        if(n < 0){
            n *= -1;
            flag = true;
        }
        while(pow < n / 2){
            tmp = tmp * tmp;
            pow = pow * 2;
        }

        tmp = tmp * myPow(x, n - pow);

        return flag ? 1 / tmp : tmp;
    }
}
