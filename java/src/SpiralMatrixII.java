/**
 * Creator : wts
 * Date : 6/15/18
 * Title : 59. Spiral Matrix II
 * Description : Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 *
 * Output:
 * [[ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]

 * Analysis :
 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        Recursion(ans, 0, n, 0);

        return ans;
    }

    public void Recursion(int[][] ans, int circle, int n, int current){

        if(current == n * n) return;

        int row = n - circle * 2;
        int col = n - circle * 2;
        //row = 0
        for(int i = 0; i < col; i++){
            ans[circle][i + circle] = ++current;
        }

        //col = col -1
        for(int i = 1; i < row; i++){
            ans[i + circle][col - 1 + circle] = ++current;
        }

        //row = row - 1
        for(int i = col - 2; i >= 0; i--){
            ans[row - 1 + circle][i + circle] = ++current;
        }

        //col = 0
        for(int i = row - 2; i > 0; i--){
            ans[i + circle][circle] = ++current;
        }

        Recursion(ans, ++circle, n, current);

    }
}
