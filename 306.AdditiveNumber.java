class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, 0);
    }

    private boolean dfs(String num, int index, int count, long prevprev, long prev) {
        if (index >= num.length()) {
            return count > 2;
        }

        long current = 0;
        for (int i = index; i < num.length(); i++) {
            char c = num.charAt(i);

            if (num.charAt(index) == '0' && i > index) {
                return false;
            }

            current = current * 10 + c - '0';
            
            if (count >= 2) {
                long sum = prevprev + prev;
                if (current > sum) {
                    return false;
                }
                if (current < sum) {
                    continue;
                }
            }

            if (dfs(num, i + 1, count + 1, prev, current)) {
                return true;
            }
        }

        return false;
    }
}
