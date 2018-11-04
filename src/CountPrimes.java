/**
 * Creator : wangtaishan
 * Date : 2018/9/1
 * Title : 204. Count Primes
 * Description :
 *
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * Analysis :
 *
 * //time complexity O(Nloglog（N）)
 *
 *     //i starts from 2 to the sqrt of n, seive if the number (i * i + ? * i) < n as a no-prime number,
 *     //why don't we iterate like i * 2, i * 3 ... i * i, i * (i + 1) ?
 *     //because before we iterate the index i, we already went through those i * 2, i * 3..
 *
 */

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] seive = new boolean[n];
        if(n < 3) return 0;
        int count = 0;
        for(int i = 2; i < Math.sqrt(n); i++){
            if(!seive[i]){
                //count++;
                for(int j = i * i; j < n; j += i){
                    if(!seive[j]){
                        count++;
                        seive[j] = true;
                    }
                }
            }
        }
        return n - 2 - count;
    }
}

