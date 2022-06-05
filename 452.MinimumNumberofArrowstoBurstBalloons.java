class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length <= 1){
            return points.length;
        }
        //deduction of two big minus numbers might out of range of int
        Arrays.sort(points, (int[] a, int[] b) -> (a[1] > b[1] ? 1 : -1));
        int minEnd = points[0][1];
        int result = 1;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > minEnd){
                result++;
                minEnd = points[i][1];
            }
        }
        return result;
    }
}
