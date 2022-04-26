class Solution {
    public int totalNQueens(int n) {
        if(n < 1){
            return 0;
        }
        int[] queen = new int[n];
        HashSet<Integer> columnSet = new HashSet<>();
        HashSet<Integer> diagno1 = new HashSet<>();
        HashSet<Integer> diagno2 = new HashSet<>();
        return helper(n, 0, columnSet, diagno1, diagno2);
    }

    public int  helper(int n, int row, HashSet<Integer> columnSet,
                        HashSet<Integer> diagno1, HashSet<Integer> diagno2){
        if(row == n){
            return 1;
        }else{
            int count = 0;
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
                count += helper(n, row + 1, columnSet,diagno1, diagno2);
                columnSet.remove(i);
                diagno1.remove(i + row);
                diagno2.remove(i - row);
            }
            return count;
        }
    }
}
