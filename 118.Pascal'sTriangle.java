class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    row.add(1);
                    continue;
                }
                row.add(results.get(i - 1).get(j - 1) + results.get(i - 1).get(j));
            }
            results.add(row);
        }
        return results;
    }
}
