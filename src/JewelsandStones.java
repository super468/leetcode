import java.util.HashMap;
import java.util.Map;

/**
 * Creator : wangtaishan
 * Date : 2018/8/28
 * Title : 771. Jewels and Stones
 * Description :
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 * Analysis :
 *
 *  one line is impressive.
 */

public class JewelsandStones {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : J.toCharArray()){
            map.putIfAbsent(c, 0);
        }
        int sum = 0;
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                //map.put(c, map.get(c) + 1);
                sum++;
            }
        }
        return sum;
    }

    public int numJewelsInStones_oneline(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}

