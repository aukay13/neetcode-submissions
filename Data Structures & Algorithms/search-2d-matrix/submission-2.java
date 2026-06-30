class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0, bottom = rows-1;

        int ans_row=0;
        while (top<=bottom) {
            int curr_row = (top+bottom)/2;
            if(target < matrix[curr_row][0]){
                bottom = curr_row-1;
            }
            else if(target > matrix[curr_row][cols-1]){
                top = curr_row+1;;
            }
            else{
                ans_row = curr_row;
                break;
            }
        }        

        if(top>bottom){
            return false;
        }

        int left = 0; int right = cols-1;

        while (left <= right) {
            int mid = (left+right)/2;
            if(target>matrix[ans_row][mid]){
                left = mid + 1;
            }
            else if(target<matrix[ans_row][mid]){
                right = mid - 1;
            }
            else{
                return true;
            }
        }

        return false;
    }
}
