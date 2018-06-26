import java.util.*;

/**
 * Creator : wts
 * Date : 6/26/18
 * Title : 133. Clone Graph

 * Description :
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 Visually, the graph looks like the following:
             1
            / \
           /   \
          0 --- 2
              / \
              \_/
 * Analysis :
 * the trick is to use hashmap to store the cloned node.
 *
 */

class CloneGraphBFS {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        //Set<UndirectedGraphNode> unvistied = new HashSet<>();
        if(node == null) return null;
        HashMap<Integer, UndirectedGraphNode> visited = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int curnum = q.size();
            for(int i = 0; i < curnum; i++){
                UndirectedGraphNode cur = q.poll();
                if(!visited.containsKey(cur.label)){                    //
                    visited.put(cur.label, new UndirectedGraphNode(cur.label));
                }
                for(UndirectedGraphNode nb : cur.neighbors){
                    if(!visited.containsKey(nb.label)){                 //neighbor not cloned
                        visited.put(nb.label, new UndirectedGraphNode(nb.label));
                        visited.get(cur.label).neighbors.add(visited.get(nb.label));
                        q.offer(nb);
                    }
                    else{                                               //neighbor already cloned
                        visited.get(cur.label).neighbors.add(visited.get(nb.label));
                    }
                }
            }
        }
        return visited.get(node.label);
    }
}

 class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}

class CloneGraphDFS{
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

        if(map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode nodeclone = new UndirectedGraphNode(node.label);
        map.put(node.label, nodeclone);
        for(UndirectedGraphNode nb : node.neighbors){
            nodeclone.neighbors.add(cloneGraph(nb));
        }
        return nodeclone;
    }
}