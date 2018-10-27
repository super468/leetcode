import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * 
 * use hashmap to store the relation between parent and child
 * 
 * use dfs to go through the map to find out all child nodes going to be deleted.
 * 
 * 
 * 
 * 
 */

class Solution {
    List<Integer> ans;
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        ans = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        //build the map
        for(int i = 0; i < ppid.size(); i++){
            if(map.containsKey(ppid.get(i))){
                map.get(ppid.get(i)).add(pid.get(i));
            }
            else{
                List<Integer> list = new LinkedList<>();
                list.add(pid.get(i));
                map.put(ppid.get(i), list);
            }
        }
        
        find(map, kill);
        return ans;
        
    }
    
    public void find(Map<Integer, List<Integer>> map, int key){
        ans.add(key);
        if(map.containsKey(key)){
            for(int num : map.get(key)){
                find(map, num);
            }
        }
    }
}