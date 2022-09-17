class Solution {
    private int[] DAYS = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aArrive = helper(arriveAlice), aLeave = helper(leaveAlice), bArrive = helper(arriveBob), bLeave = helper(leaveBob);
        return Math.max(0, Math.min(aLeave, bLeave) - Math.max(aArrive, bArrive) + 1);
    }
    public int helper(String date){
        int m = Integer.valueOf(date.substring(0, 2));
        int d = Integer.valueOf(date.substring(3, 5));
        int total = 0;
        for(int i = 0; i < m; i++){
            total += DAYS[i];
        }
        return total + d;
    }
}
