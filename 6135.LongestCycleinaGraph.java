class Solution {
    public int longestCycle(int[] edges) {
        int len = edges.length;
        int[] times = new int[len];
        int result = -1;
        for(int i = 0, curTime = 1; i < len; i++){
            if(times[i] > 0){
                continue;
            }
            for(int node = i, startTime = curTime; node >= 0; node = edges[node]){
                if(times[node] > 0){
                    if(times[node] >= startTime){
                        result = Math.max(result, curTime - times[node]);
                    }
                    break;
                }
                times[node] = curTime++;
            }
        }
        return result;
    }
}
