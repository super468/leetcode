import java.util.Stack;

/**
 * Creator : wangtaishan
 * Date : 2018/8/25
 * Title : 20. Valid Parentheses
 * Description :
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 * Analysis :
 *      the first method is pretty straight forward.
 *      the second one is pretty outstanding !fo
 *
 *
 *
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(stack.empty()){
                stack.push((Character) s.charAt(i));
                continue;
            }
            if(stack.peek().equals(new Character('(')) && s.charAt(i) == ')'){
                stack.pop();

            }
            else if(stack.peek().equals(new Character('[')) && s.charAt(i) == ']'){
                stack.pop();

            }
            else if(stack.peek().equals(new Character('{')) && s.charAt(i) == '}'){
                stack.pop();

            }
            else stack.push((Character) s.charAt(i));

        }
        return stack.empty() ? true : false;
    }

    public boolean isValid_Duxiu(String s){
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(stack.empty() || stack.pop() != c)
                return false;
        }
        return stack.empty() ? true : false;
    }
}
