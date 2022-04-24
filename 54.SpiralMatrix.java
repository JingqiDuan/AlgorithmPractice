class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0 || matrix[0] == null){
            return result;
        }
        int upperBorder = 0;
        int rightBorder = matrix[0].length - 1;
        int lowerBorder = matrix.length - 1;
        int leftBorder = 0;
        while(true){
            //left to right
            for(int i = leftBorder; i <= rightBorder; i++){
                result.add(matrix[upperBorder][i]);
            }
            if(++upperBorder > lowerBorder){
                break;
            }
            //top to bottom
            for(int i = upperBorder; i <= lowerBorder; i++){
                result.add(matrix[i][rightBorder]);
            }
            if(--rightBorder < leftBorder){
                break;
            }
            //right to left
            for(int i = rightBorder; i >= leftBorder; i--){
                result.add(matrix[lowerBorder][i]);
            }
            if(--lowerBorder < upperBorder){
                break;
            }
            //bottom to top
            for(int i = lowerBorder; i >= upperBorder; i--){
                result.add(matrix[i][leftBorder]);
            }
            if(++leftBorder > rightBorder){
                break;
            }
        }
        return result;
    }
}
