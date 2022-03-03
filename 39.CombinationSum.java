class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return results;
        }
        Stack<Integer> path = new Stack<>();
        helper(candidates, 0, path, target, results);
        return results;
    }

    private void helper(int[] candidates, int start, Stack<Integer> path, 
                        int target, List<List<Integer>> results){
        if(target == 0){
           results.add(new ArrayList<>(path)); 
        }
        if(target < 0){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            path.push(candidates[i]);
            helper(candidates, i, path, target - candidates[i], results);
            path.pop();
        }
    }
}
