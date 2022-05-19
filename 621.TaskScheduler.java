class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for(char ch : tasks){
            counter[ch - 'A']++;
        }
        Arrays.sort(counter);
        int maxFreq = counter[25];
        //last one don't need slots
        int slotsNum = (maxFreq - 1) * n;
        for(int i = 24; i >= 0; i--){
            //most slots can be filled per alph
            slotsNum -= Math.min(maxFreq - 1, counter[i]);
        }
        //corner case n = 0
        return slotsNum > 0 ? slotsNum + tasks.length : tasks.length;
    }
}
