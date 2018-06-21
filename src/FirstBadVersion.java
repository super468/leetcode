/**
 * Creator : wts
 * Date : 6/21/18
 * Title : 278. First Bad Version
 * Description :
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 *
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 * Analysis : no brain BinarySearch
 */

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid) == true){
                end = mid;
            }
            else start = mid;
        }

        if(isBadVersion(start) == true)
            return start;
        if(isBadVersion(end) == true)
            return end;

        return n;
    }

    public boolean isBadVersion(int version){
        return true;
    }
}
