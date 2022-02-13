class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = findTheRow(matrix, target);
        if(row < 0){
            return false;
        }
        return searchRow(matrix[row], target);
    }
    //only through experimenting on draft
    private int findTheRow(int[][]matrix, int target){
        int left = -1, right = matrix.length - 1;
        while(left < right){
            int mid = left + (right - left + 1)/2;
            if(matrix[mid][0] <= target){
                left = mid;
            }else{
                right = right - 1;
            }
        }return left;
    }
    private boolean searchRow(int[] row, int target){
        int left = 0, right = row.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(row[mid] < target){
                left = mid + 1;
            }else if(row[mid] == target){
                return true;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}

/*class Solution2 {
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
}*/


