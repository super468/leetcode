/**
 * Creator : wts
 * Date : 6/22/18
 * Title : 74. Search a 2D Matrix
 * Description :
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 *
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 *
 * Input:
 *
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 *
 * target = 3
 *
 * Output: true
 *
 * Example 2:
 *
 * Input:
 *
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 *
 * target = 13
 *
 * Output: false
 *
 * Analysis : binary search
 *
 * 另一种办法可以提前把start 和 end 换成 0 和 row * col - 1
 */

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row < 1) return false;
        int col = matrix[0].length;
        if(col < 1) return false;
        int start_i = 0;
        int start_j = 0;
        int end_i = row - 1;
        int end_j = col - 1;
        while(start_i * col + start_j + 1 < end_i * col + end_j){
            int mid_i = (start_i * col + start_j + end_i * col + end_j) / 2 / col;
            int mid_j = (start_i * col + start_j + end_i * col + end_j) / 2 % col;
            if(matrix[mid_i][mid_j] == target)
                return true;
            else if(matrix[mid_i][mid_j] > target){
                end_i = mid_i;
                end_j = mid_j;
            }else{
                start_i = mid_i;
                start_j = mid_j;
            }
        }

        if(matrix[start_i][start_j] == target)
            return true;
        if(matrix[end_i][end_j] == target)
            return true;

        return false;
    }
}
