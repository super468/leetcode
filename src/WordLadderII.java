import java.util.*;

/**
 * Creator : wts
 * Date : 6/25/18
 * Title : 126. Word Ladder II
 * Description :
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return an empty list if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output:
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: []

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 * Analysis :
 *
 * 这道题要找的是所有最短的路径，可以想到DFS，那么就是BFS + DFS 这样一种解法。
 *
 * 设定两个set ,一个是unvisited 一个是 visited。即使结点被访问过了，也要等到这一层都结束了再删除，因为它有可能是上一层其他点的子结点。
 *
 * 也就是说一个结点可以有多个父亲。用 Hashmap 表示这种关系。然后bottom up backtracking。
 *
 * 注意remove 和 removeAll 区别，这个卡了我半天。
 */

public class WordLadderII {
    public static void main(String[] args){
        WordLadderII w = new WordLadderII();
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";
        List<List<String>> re = w.findLadders(beginWord, endWord, wordList);

    }

    List<List<String>> list;
    Map<String, List<String>> parentmap;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> unvisited = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<>();
        list = new LinkedList<List<String>>();
        List<String> row = new LinkedList<>();
        Queue<String> q = new LinkedList<String>();
        parentmap = new HashMap<String, List<String>>();
        q.offer(beginWord);
        //row.add(beginWord);
        int height = 0;
        int min_height = Integer.MAX_VALUE;
        unvisited.add(endWord);
        unvisited.remove(beginWord);
        while(!q.isEmpty()){
            int cur = q.size();
            for(int i = 0; i < cur; i++){
                String p = q.poll();
                for(int j = 0; j < p.length(); j++){
                    char[] chars = p.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[j] = c;
                        String word = new String(chars);
                        //if(word.equals(p)) continue;
                        if(unvisited.contains(word)){
                            if(visited.add(word)){
                                q.offer(word);
                            }
                            if(parentmap.containsKey(word)){
                                parentmap.get(word).add(p);
                            }
                            else{
                                List<String> parentlist = new LinkedList<>();
                                parentlist.add(p);
                                parentmap.put(word, parentlist);
                            }
                            if(word.equals(endWord)){
                                min_height = height;
                            }
                        }

                    }
                }
            }
            if(height == min_height) {
                break;
            }
            unvisited.removeAll(visited);
            height++;
        }

        Backtracking(endWord, beginWord, row);
        return list;
    }

    public void Backtracking(String word, String start, List<String> row){
        if(word.equals(start)){
            row.add(0, word);
            list.add(new LinkedList<String>(row));
            row.remove(0);
            return;
        }

        row.add(0, word);
        if (parentmap.get(word)!=null){
            for(String s : parentmap.get(word)){
                Backtracking(s, start, row);
            }
        }
        row.remove(0);

    }
}
