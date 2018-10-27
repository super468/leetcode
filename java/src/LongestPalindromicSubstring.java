/**
 * Creator : wangtaishan
 * Date : 2018/8/9
 * Title : 5. Longest Palindromic Substring
 * Description :
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 * Analysis : 这道题利用dp，设计一个二维boolean数组，表示substrings的回文性。
 *
 * 提前设好长度为1 和 2 的 substring的 回文性。
 *
 * 然后increase the length of the substring, determine the palindromic of substrings by using the previous substrings.
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() == 0) return "";
        int len = s.length();
        boolean[][] map = new boolean[len][len];
        int longest = 0;
        for(int i = 0; i < map.length; i++){
            map[i][i] = true;
        }

        for(int i = 0; i < map.length - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                map[i][i + 1] = true;
                longest = 1;
            }
        }

        for(int k = 2; k < len; k++){
            for(int i = 0; i < len; i++){
                int j = i + k;
                if(j >= len) continue;
                if(s.charAt(i) == s.charAt(j) && map[i + 1][j - 1] == true){
                    longest = k;
                    map[i][j] = true;
                }
            }

        }

        for(int i = 0; i < len; i++)
            for(int j = i; j < len; j++){
                if(j - i == longest && map[i][j] == true){
                    return s.substring(i, j + 1);
                }
            }

        return "";
    }

    public static void main(String[] args){
        String s = "aaaa";
        LongestPalindromicSubstring fun = new LongestPalindromicSubstring();
        System.out.println(fun.longestPalindrome(s));
    }
}
