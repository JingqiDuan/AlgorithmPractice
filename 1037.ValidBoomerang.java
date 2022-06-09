class Solution {
    public boolean isBoomerang(int[][] points) {
        if(points.length <= 2){
            return true;
        }
        int[] v1 = new int[]{points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] v2 = new int[]{points[2][0] - points[1][0], points[2][1] - points[1][1]};
        //parallel => y1/x1 = y2/x2  => y1 * x2 = y2 * x1
        return v1[0] * v2[1] - v2[0] * v1[1] != 0;
    }
}
