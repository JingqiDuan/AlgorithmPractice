class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if(n <= 0){
            return results;
        }
        Stack<Integer> subset = new Stack<>();
        helper(n, k, 1, subset, results, 0);
        return results;
    }

    private void helper(int n, int k, int start, Stack<Integer> subset, 
                        List<List<Integer>> results, int depth){
        if(k == depth){
            results.add(new ArrayList<>(subset));
        }
        for(int i = start; i <= n; i++){
            if(depth >= k){
                continue;
            }
            subset.push(i);
            helper(n, k, i + 1, subset, results, depth + 1);
            subset.pop();
        }
    }
}
