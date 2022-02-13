class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length - 1;
        int left = 0, right = n;
        int i = 0;
        //use while loop as the increament of i is compliant to a certain condition
        while(i < m){
            if(matrix[i][n] == target){
                return true;
            }
            if(matrix[i][n] < target){
                i ++;
                if(i == m){
                    return false;
                }
            }else{
                while(left <= right){
                    int mid = left + (right - left) / 2;
                    if(matrix[i][mid] < target){
                        left = mid + 1;
                    }else if(matrix[i][mid] == target){
                        return true;
                    }else{
                        right = mid - 1;
                    }
                }
                i ++;
            }
        }
        return false;
    }
}
