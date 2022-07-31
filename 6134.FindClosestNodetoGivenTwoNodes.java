class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] d1 = calcDis(node1, edges), d2 = calcDis(node2, edges);
        int ans = -1, n = edges.length;
        for (int i = 0, minDis = n; i < n; ++i) {
            int d = Math.max(d1[i], d2[i]);
            if (d < minDis) {
                minDis = d;
                ans = i;
            }
        }
        return ans;
    }

    public int[] calcDis(int x, int[] edges) {
        int n = edges.length;
        int[] dis = new int[n];
        Arrays.fill(dis, n);
        for (int i = 0; x >= 0 && dis[x] == n; x = edges[x])
            dis[x] = i++;
        return dis;
    }
}
