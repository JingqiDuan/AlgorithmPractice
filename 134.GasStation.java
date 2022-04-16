class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int totalTank = 0;
        int curTank = 0;
        int startStation = 0;
        for(int i = 0; i < len; i++){
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if(curTank < 0){
                startStation = i + 1;
                curTank = 0;
            }
        }
        return totalTank >= 0 ? startStation : -1;
    }
}
