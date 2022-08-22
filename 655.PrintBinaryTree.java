class Solution {
    int h, m, n;
    List<List<String>> ans;
    public List<List<String>> printTree(TreeNode root) {
        dfs1(root, 0);
        m = h + 1; n = (1 << (h + 1)) - 1;
        ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < n; j++) cur.add("");
            ans.add(cur);
        }
        dfs2(root, 0, (n - 1) / 2);
        return ans;
    }
    void dfs1(TreeNode root, int depth) {
        if (root == null) return ;
        h = Math.max(h, depth);
        dfs1(root.left, depth + 1);
        dfs1(root.right, depth + 1);
    }
    void dfs2(TreeNode root, int x, int y) {
        if (root == null) return ;
        ans.get(x).set(y, String.valueOf(root.val));
        dfs2(root.left, x + 1, y - (1 << (h - x - 1)));
        dfs2(root.right, x + 1, y + (1 << (h - x - 1)));
    }
} 
