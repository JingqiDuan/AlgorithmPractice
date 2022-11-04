class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int cur = 0, i = 0;
        while(cur < target || (cur - target) % 2 == 1){
           i++;
           cur += i;
        }
        return i;
    }
}
