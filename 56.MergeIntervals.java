class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        int i = 0;
        int j = 1;
        while(i < intervals.length){
            //check if overlapped
            if(j < intervals.length && intervals[j][0] <= intervals[i][1]){
                int leftBorder = Math.min(intervals[i][0], intervals[j][0]);
                int rightBorder = Math.max(intervals[i][1], intervals[j][1]);
                intervals[i][0] = leftBorder;
                intervals[i][1] = rightBorder;
                j++;
            }else{
                result.add(new int[]{intervals[i][0], intervals[i][1]});
                i = j;
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
