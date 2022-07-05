class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        helper(1, path, k, n, result);
        return result;
    }

    public void helper(int start, Stack<Integer> path, int k, int n, List<List<Integer>> result){
        if(k == 0 && n == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(n < 0 || k <= 0){
            return;
        }
        for(int i = start; i <= 9; i++){
            path.push(i);
            helper(i + 1, path, k - 1, n - i, result);
            path.pop();
        }
    }
}
