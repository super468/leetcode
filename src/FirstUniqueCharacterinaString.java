/**
 * Creator : wangtaishan
 * Date : 2018/9/1
 * Title : 387. First Unique Character in a String
 * Description :
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 *
 * Analysis :
 *
 *      use a array to count how many times each character appears
 *
 *      iterate the chars in the string, see if any character appears once then return that character.
 *
 *      Otherwise, return -1;
 *
 *
 */

public class FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {
        int[] dict = new int[26];
        for(char c : s.toCharArray()){
            dict[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(dict[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
