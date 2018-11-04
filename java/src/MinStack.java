import java.util.*;

/**
 * Creator : wangtaishan
 * Date : 2018/8/28
 * Title : 155. Min Stack
 * Description :
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * Analysis :
 *
 *  use map store the minimum value in the current state.
 *
 *  also one stack would be less space consuming.
 */

public class MinStack {
    List<Integer> list;
    Map<Integer, Integer> map;
    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        list.add(x);
        if(list.size() < 2){
            map.put(list.size() - 1, x);
        }
        else{
            map.put(list.size() - 1, Math.min(map.get(list.size() - 2), x));
        }
    }

    public void pop() {
        if(list == null) return;
        int key = list.size() - 1; // don't use size() twice
        list.remove(key);
        map.remove(key);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return map.get(list.size() - 1);
    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
