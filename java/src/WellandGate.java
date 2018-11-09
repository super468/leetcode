import java.util.LinkedList;
import java.util.Queue;

public class WellandGate {
    class Solution {

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public void wallsAndGates(int[][] rooms) {
            for(int i = 0; i < rooms.length; i++)
                for(int j = 0; j < rooms[0].length; j++){
                    if(rooms[i][j] == 0) dfs(rooms, i, j);
                }
        }

        public void dfs(int[][] rooms, int x, int y){
            int row = rooms.length;
            int col = rooms[0].length;
            for(int i = 0; i < directions.length; i++){
                int dx = x + directions[i][0];
                int dy = y + directions[i][1];
                if(0 <= dx && dx < row && 0 <= dy && dy < col && rooms[dx][dy] > rooms[x][y] + 1){
                    rooms[dx][dy] = rooms[x][y] + 1;
                    dfs(rooms, dx, dy);
                }
            }
        }
    }

    class Solution2{

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public void wallsAndGates(int[][] rooms) {
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < rooms.length; i++)
                for(int j = 0; j < rooms[0].length; j++){
                    if(rooms[i][j] == 0) q.add(i*rooms[0].length+j);
                }

            while(!q.isEmpty()){
                int val =  q.poll();
                int x = val / rooms[0].length;
                int y = val % rooms[0].length;
                for(int i = 0; i < directions.length; i++){
                    int dx = x + directions[i][0];
                    int dy = y + directions[i][1];
                    if(0 <= dx && dx < rooms.length && 0 <= dy && dy < rooms[0].length && rooms[dx][dy] == Integer.MAX_VALUE){
                        rooms[dx][dy] = rooms[x][y] + 1;
                        q.add(dx*rooms[0].length+dy);
                    }
                }
            }
        }

    }
}

