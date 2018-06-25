import java.util.*;

/**
 * Creator : wts
 * Date : 6/25/18
 * Title : 127. Word Ladder
 * Description :
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

 * Analysis :
 *
 * 这道题典型的BFS，对于current word，find all one word different strings in the list, and then move to next level.
 *
 * 关键在于如何找到one word different string, 如果拿current string compare each word in the wordlist is consuming time.
 *
 * the time complexity is size of wordlist O(N). But if we change each char of current word from "a" to "z" and
 *
 * use hashset to see if the changed is in the set, it cost constant time 26, which is faster if the size of wordlist
 *
 * is getting bigger.
 *
 */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int height = 0;
        q.offer(beginWord);
        while(!q.isEmpty()){
            int cur = q.size();
            for(int i = 0; i < cur; i++){
                String p = q.poll();
                if(p.equals(endWord)){
                    return height + 1;
                }
                else{

                    for(int k = 0; k < p.length(); k++){
                        char[] chars = p.toCharArray();
                        for(char j = 'a'; j <= 'z'; j++){
                            chars[k] = j;
                            String word = new String(chars);
                            if(set.contains(word)){
                                q.offer(word);
                                set.remove(word);
                            }
                        }
                    }
                }
            }
            height++;
        }

        return 0;
    }
}
