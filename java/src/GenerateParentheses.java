import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Creator : wangtaishan
 * Date : 2018/8/25
 * Title : 22. Generate Parentheses
 * Description :
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * Analysis :
 *
 *      the main idea is that let the number of ')' is not greater than that of '('.
 *
 *
 */

public class GenerateParentheses {
    List<String> ans = new ArrayList<String>();
    public List<String> fuckingstupidsolution(int n) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder s = new StringBuilder();
        Backtracking(n, s, stack, 0);
        return ans;
    }

    void Backtracking(int n, StringBuilder s, Stack<Character> stack, int open){
        if(s.length() / 2 == n){
            ans.add(s.toString());
            return;
        }

        if(stack.empty()){
            s.append('(');
            stack.push(')');
            Stack<Character> ss = new Stack<Character>();
            ss.addAll(stack);
            Backtracking(n, new StringBuilder(s.toString()), ss, ++open);
        }
        else{

            if(open < n){
                s.append('(');
                stack.push(')');
                Stack<Character> ss = new Stack<Character>();
                ss.addAll(stack);
                Backtracking(n, new StringBuilder(s.toString()), ss, ++open);
                s.deleteCharAt(s.length() - 1);
                stack.pop();
                open--;
            }

            s.append(')');
            stack.pop();
            Stack<Character> sss = new Stack<Character>();
            sss.addAll(stack);
            Backtracking(n, new StringBuilder(s.toString()), sss, open);
        }
    }


    public List<String> generateParenthesis(int n) {
        Backtracking(n, "", 0, 0);
        return ans;
    }

    void Backtracking(int n, String s, int open, int close){
        if(s.length() / 2 == n){
            ans.add(s);
            return;
        }
        if(open < n){
            Backtracking(n, s + "(", open + 1, close);
        }
        if(close < open){
            Backtracking(n, s + ")", open, close + 1);
        }
    }
}
