class Solution {
    public int[][] generateMatrix(int n) {
        if(n == 0){
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int value = 1;
        while(true){
            for(int i = left; i <= right; i++){
                result[top][i] = value++; 
            }
            if(++top > bottom){
                break;
            }
            for(int i = top; i <= bottom; i++){
                result[i][right] = value++;
            }
            if(--right < left){
                break;
            }
            for(int i = right; i >= left; i--){
                result[bottom][i] = value++;
            }
            if(--bottom < top){
                break;
            }
            for(int i = bottom; i >= top; i--){
                result[i][left] = value++;
            }
            if(++left > right){
                break;
            }
        }
        return result;
    }
}
