import java.util.LinkedList;
import java.util.Queue;

/**
 * Creator : wts
 * Date : 6/26/18
 * Title : 207. Course Schedule
 * Description :
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 Example 1:

 Input: 2, [[1,0]]
 Output: true
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0. So it is possible.
 Example 2:

 Input: 2, [[1,0],[0,1]]
 Output: false
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0, and to take course 0 you should
 also have finished course 1. So it is impossible.
 Note:

 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.

 * Analysis :
 */

class CourseScheduleBFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length < 1 || prerequisites == null) return true;
        Queue<Integer> q = new LinkedList<>();
        int[] degree = new int[numCourses];
        int[][] matrix = new int[numCourses][numCourses];
        for(int[] p : prerequisites){
            if(matrix[p[0]][p[1]] == 1) continue;
            matrix[p[0]][p[1]] = 1;
            degree[p[0]]++;
        }

        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(degree[i] == 0){
                q.offer(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int p = q.poll();
            for(int i = 0; i < numCourses; i++){
                if(matrix[i][p] == 1){
                    if(degree[i] == 1){
                        q.offer(i);
                        count++;
                    }
                    degree[i]--;
                }

            }
        }
        return count == numCourses ? true : false;


    }
}
