import java.util.HashMap;

/**
 * Creator : wangtaishan
 * Date : 2018/8/27
 * Title : 819. Most Common Word
 * Description :
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 * Note:
 *
 * 1 <= paragraph.length <= 1000.
 * 1 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * Different words in paragraph are always separated by a space.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols.
 *
 *
 * Analysis :
 *
 *  learn how to use regex replace special letter.
 *
 *  map.getOrDefault(key , value) return the value to which the key is mapped or just the parameter value.
 *
 *  map.keySet() return a Set of the map keys.
 */

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] splitArr = paragraph.replaceAll("[!?',;.]","").toLowerCase().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(String string: splitArr){
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        for(String word : banned){
            if(map.containsKey(word)){
                map.remove(word);
            }
        }
        String max = null;
        int num = 0;
        for(String string : map.keySet()){
            if(num < map.get(string)){
                num = map.get(string);
                max = string;
            }
        }
        return max;

    }
}