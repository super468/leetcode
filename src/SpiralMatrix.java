import java.util.ArrayList;
import java.util.List;

/**
 * Creator : wts
 * Date : 6/15/18
 * Title : 54. Spiral Matrix
 * Description : Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 *
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Analysis :  这种题就是考细节的，注意cornet case。螺旋的时候注意要有区分。
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int row = matrix.length;
        if(row < 1) return list;
        int col = matrix[0].length;
        if(col < 1) return list;

        Recursion(matrix, list, 0);

        return list;

    }

    public void Recursion(int[][] matrix, List<Integer> list, int circle){

        int row = matrix.length - circle * 2;
        if(row < 1) return;
        int col = matrix[0].length - circle * 2;
        if(col < 1) return;

        if(row == 1 || col == 1){
            for(int i = 0; i < row; i++)
                for(int j = 0; j < col; j++)
                    list.add(matrix[circle+i][circle + j]);
            return;
        }

        //row = 0
        for(int i = 0; i < col; i++){
            list.add(matrix[circle][i + circle]);
        }

        //col = col -1
        for(int i = 1; i < row; i++){
            list.add(matrix[i + circle][col - 1 + circle]);
        }

        //row = row - 1
        for(int i = col - 2; i >= 0; i--){
            list.add(matrix[row - 1 + circle][i + circle]);
        }

        //col = 0
        for(int i = row - 2; i > 0; i--){
            list.add(matrix[i + circle][circle]);
        }

        circle++;

        Recursion(matrix, list, circle);


    }
}
