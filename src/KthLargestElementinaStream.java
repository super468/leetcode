/**
 * use min heap implemented by priority queue
 * 
 * initialize a k size capcacity pq, and fill the queue using
 * 
 * the input array.
 * 
 * if a new value is going to be added, check if the queue has
 * 
 * reached its capacity.
 * 
 * if not, just add it into the queue
 * 
 * or compare the value to the peek value of the queue to decide
 * 
 * whether to replace it or not.
 * 
 * the kth largest element will always be the peek of the queue.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
import java.util.Comparator;
import java.util.PriorityQueue;
class KthLargest {
    PriorityQueue<Integer> queue;
        int cap;
        public KthLargest(int k, int[] nums) {     
            cap = k;
            queue = new PriorityQueue<>(k, new KComparator());
            for(int num : nums){
                if(queue.size() < k){
                    queue.offer(num);
                }
                else{
                    if(num > queue.peek()){
                        queue.poll();
                        queue.offer(num);
                    }
                }
            }
        }
        
        public class KComparator implements Comparator<Integer>{
            public int compare(Integer a, Integer b){
                //ascending order
                if(a > b){
                    return 1;
                }
                else if(a < b){
                    return -1;
                }
                else return 0;
            }
        }
        
        public int add(int val) {
            if(queue.size() < cap){
                queue.offer(val);
            }
            else{
                if(val > queue.peek()){
                    queue.poll();
                    queue.offer(val);
                }
            }
            
            return queue.peek();
        }
    }