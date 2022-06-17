class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> results = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        helper(root, map, results);
        return results;
    }
    public String helper(TreeNode root, HashMap<String, Integer> map, List<TreeNode> results){
        if(root == null){
            return "null";
        }
        //without "," will cause error, eg, 11 and 1 will become 111 regardless the sequence
        String serialized = root.val + "," + helper(root.left, map, results) + "," + helper(root.right, map, results);
        map.put(serialized, map.getOrDefault(serialized, 0) + 1);
        if(map.get(serialized) == 2){
            results.add(root);
        }
        return serialized;
    }
}
