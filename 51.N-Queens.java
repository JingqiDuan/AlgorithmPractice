class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if(n < 1){
            return results;
        }
        int[] queen = new int[n];
        Arrays.fill(queen, -1);
        HashSet<Integer> columnSet = new HashSet<>();
        HashSet<Integer> diagno1 = new HashSet<>();
        HashSet<Integer> diagno2 = new HashSet<>();
        helper(queen, n, 0, columnSet, diagno1, diagno2, results);
        return results;
    }

    public void helper(int[] queen, int n, int row, HashSet<Integer> columnSet,
                        HashSet<Integer> diagno1, HashSet<Integer> diagno2, List<List<String>> results){
        if(row == n){
            results.add(new ArrayList<String>(generateBoard(queen, n)));
        }
        for(int i = 0; i < n; i++){
            if(columnSet.contains(i)){
                continue;
            }
            if(diagno1.contains(i + row)){
                continue;
            }
            if(diagno2.contains(i - row)){
                continue;
            }
            columnSet.add(i);
            diagno1.add(i + row);
            diagno2.add(i - row);
            queen[row] = i;
            helper(queen, n, row + 1, columnSet,diagno1, diagno2, results);
            columnSet.remove(i);
            diagno1.remove(i + row);
            diagno2.remove(i - row);
            queen[row] = -1;
        }
    }

    public ArrayList<String> generateBoard(int[] queen, int n){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            char[] row = new char[n];
            StringBuilder sb = new StringBuilder();
            Arrays.fill(row, '.');
            row[queen[i]] = 'Q';
            for(char c : row){
                sb.append(c);
            }
            result.add(sb.toString());
        }
        return result;
    }
}
