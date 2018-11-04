/**
 * Creator : wangtaishan
 * Date : 2018/9/3
 * Title : 73. Set Matrix Zeroes
 * Description :
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 *
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * Example 2:
 *
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 *
 * Analysis :
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if(matrix.length < 1 || matrix[0].length < 1) return;
        int row_len = matrix.length;
        int col_len = matrix[0].length;
        partion(matrix, 0, 0, row_len - 1, col_len - 1);
    }

    public void partion(int[][] matrix, int start_i, int start_j, int end_i, int end_j){
        if(start_i > end_i || start_j > end_j) return;
        for(int i = start_i; i <= end_i; i++)
            for(int j = start_j; j <= end_j; j++){
                if(matrix[i][j] == 0){
                    for(int col = start_j; col <= end_j; col++)
                        matrix[i][col] = 0;
                    for(int row = start_i; row <= end_i; row++)
                        matrix[row][j] = 0;
                    partion(matrix, start_i, start_j, i - 1, j - 1);
                    partion(matrix, start_i, j + 1, i - 1, end_j);
                    partion(matrix, i + 1, start_j, end_i, j - 1);
                    partion(matrix, i + 1, j + 1, end_i, end_j);
                    return;
                }
            }
    }

    public static void main(String[] args){
        int[][] input = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        SetMatrixZeroes s = new SetMatrixZeroes();
        s.setZeroes(input);
    }
}
