class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> result = new ArrayList<>();
        if(arrays.length == 0 || arrays[0].length == 0){
            return result;
        }
        int max = 0;
        for(int i = 0; i < arrays.length; i++){
            for(int j = 0; j < arrays[i].length; j++){
                max = Math.max(max, arrays[i][j]);
            }
        }
        
        int len = max + 1;
        int[] counter = new int[len];
        for(int[] row : arrays){
            for(int n : row){
                counter[n]++;
            }
        }

        for(int i = 0; i < len; i++){
            if(counter[i] == arrays.length){
                result.add(i);
            }
        }
        return result;
    }
}
