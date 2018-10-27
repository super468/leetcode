/**
 * Creator : wangtaishan
 * Date : 2018/8/25
 * Title : 14. Longest Common Prefix
 * Description :
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 *
 * Analysis : 找到最小的string，然后iterate the list compare the char by index. index also creases.
 *
 * O(N^2)
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE;
        String shortest = "";
        for(String str : strs){
            if(str.length() < len){
                shortest = str;
                len = str.length();
            }
        }

        for(int i = 0; i < shortest.length(); i++){
            for(String str : strs){
                if(str.charAt(i) != shortest.charAt(i)){
                    return shortest.substring(0,i);
                }
            }
        }

        return shortest;
    }

}
