import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wts
 * Date : 7/2/18
 * Title : 131. Palindrome Partitioning
 * Description :
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]

 * Analysis :
 *
 *
 */

public class PalindromePartitioning {
    List<List<String>> list = new ArrayList<>();
    List<String> row = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.equals("")) {
            list.add(row);
            return list;
        }
        // if(s.length() == 1){
        //     row.add(s);
        //     list.add(row);
        //     return list;
        // }
        helper(s, row);
        return list;
    }

    public void helper(String s, List<String> row){
        if(s.length() == 0){
            list.add(new ArrayList<>(row));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(ispalindrome(s.substring(0,i + 1))){
                row.add(s.substring(0,i + 1));
                helper(s.substring(i + 1), row);
                row.remove(row.size() - 1);
            }
        }
    }

    public boolean ispalindrome(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
