class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] jobs = new int[len][];
        int[] dp = new int[len + 1];
        for(int i = 0; i < len; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        for(int i = 1; i <= len; i++){
            int j = search(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[j + 1] + jobs[i - 1][2]);
        }
        return dp[len];
    }
    public int search(int[][] jobs, int right, int targetEnd){
        //(-1, 4) left open, right open
        int left = -1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(jobs[mid][1] <= targetEnd){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
