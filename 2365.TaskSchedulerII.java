class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long cur = 1;
        HashMap<Integer, Long> map = new HashMap<>();
        for (int k : tasks) {
            if (map.containsKey(k) && cur < map.get(k)) {
                cur = map.get(k);
            }
            map.put(k, cur + space + 1);
            cur++;
        }
        return cur - 1;
    }
}
