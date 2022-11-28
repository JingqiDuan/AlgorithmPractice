class Solution {
    public int bestClosingTime(String customers) {
        char[] arr = customers.toCharArray();
        int n = customers.length(), result = Integer.MAX_VALUE;
        int[] left = new int[n + 1], right = new int[n + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++){
            left[i + 1] = left[i] + (arr[i] == 'N' ? 1 : 0);
            right[n - i - 1] = right[n - i] + (arr[n - i - 1] == 'Y' ? 1 : 0);
        }
        
        for(int i = 0; i <= n; i++){
            int tmp = left[i] + right[i];
            result = Math.min(result, tmp);
            heap.add(new int[]{result, i});
        }
        return heap.poll()[1];
    }
}
