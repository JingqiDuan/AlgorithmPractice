class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(candidates.length == 0 || candidates == null){
            return results;
        }
        Stack<Integer> subComb = new Stack<>();
        Arrays.sort(candidates);//important
        helper(candidates, 0, subComb, target, results);
        return results;
    }

    private void helper(int[] candidates, int index, Stack<Integer> subComb, 
                        int target, List<List<Integer>> results){
        if(target == 0){
            results.add(new ArrayList<>(subComb));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(target - candidates[i] < 0){//pruning
                break;
            }
            if(i > index && candidates[i] == candidates[i - 1]){//pruning
                continue;
            }
            subComb.push(candidates[i]);
            helper(candidates, i + 1, subComb, target - candidates[i], results);//it's i + 1 not index + 1
            subComb.pop();
        }
    }
}
