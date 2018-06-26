import java.util.LinkedList;
import java.util.Queue;

/**
 * Creator : wts
 * Date : 6/26/18
 * Title :  210. Course Schedule II
 * Description : return the ordering of courses you should take to finish all courses.
 * Analysis :
 */

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        //if(prerequisites.length < 1 || prerequisites == null) return true;

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
                result[count] = i;
                count++;
            }
        }

        while(!q.isEmpty()){
            int p = q.poll();
            for(int i = 0; i < numCourses; i++){
                if(matrix[i][p] == 1){
                    if(degree[i] == 1){
                        q.offer(i);
                        result[count] = i;
                        count++;
                    }
                    degree[i]--;
                }

            }
        }

        return count == numCourses ? result : new int[0];
    }
}
