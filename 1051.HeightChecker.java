class Solution {
    public int heightChecker(int[] heights) {
        int[] counter = new int[101];
        for(int height : heights){
            counter[height]++;
        }
        int result = 0;
        int index = 0;
        for(int i = 1; i <= 100; i++){
            if(counter[i] == 0){
                continue;
            }
            for(int j = 0; j < counter[i]; j++){
                if(i != heights[index++]){
                    result++;
                }
            }
        }
        return result;
    }
}
