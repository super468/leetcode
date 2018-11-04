import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creator : wangtaishan
 * Date : 2018/8/25
 * Title : 17. Letter Combinations of a Phone Number
 * Description :
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * Analysis : Backtacking method
 *
 * used the StringBuilder to change the String during processing
 */

public class LetterCombinationsofaPhoneNumber {
    List<String> ans = new ArrayList<String>();



    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return ans;
        List<String> list = new ArrayList<String>(Arrays.asList("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));
        List<String> candidates = new ArrayList<String>();
        for(int i = 0; i < digits.length(); i++){
            String letters = list.get(digits.charAt(i) - '0');
            candidates.add(letters);
        }
        StringBuilder row = new StringBuilder();
        Backtracking(candidates, 0, row);
        return ans;
    }

    public void Backtracking(List<String> candidates, int step, StringBuilder row){
        if(row.length() == candidates.size()){
            ans.add(row.toString());
            return;
        }
        for(int i = 0; i < candidates.get(step).length(); i++){
            row.append(candidates.get(step).charAt(i));
            Backtracking(candidates, step + 1, new StringBuilder(row.toString()));
            row.deleteCharAt(row.length() - 1);
        }
    }
}
