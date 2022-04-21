class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        char[] charArr = s.toCharArray();
        Stack<String> subset = new Stack<>();
        int len = s.length();
        int[][] cache = new int[len][len];
        helper(charArr, 0, subset, cache, results);
        return results;
    }
    public void helper(char[] charArr, int start, Stack<String> subset, int[][] cache, List<List<String>> results){
        if(start == charArr.length){
            results.add(new ArrayList<>(subset));
        }
        for(int i = start; i < charArr.length; i++){
            if(isValid(charArr, start, i, cache) == 1){
                //new str from char arr
                subset.push(new String(charArr, start, i + 1 - start));
                helper(charArr, i + 1, subset, cache, results);
                subset.pop();
            }
        }
    }

    public int isValid(char[] charArr, int left, int right, int[][] cache){
        if(left >= right){
            return 1;
        }
        if(cache[left][right] != 0){
            return cache[left][right];
        }
        if(charArr[left] == charArr[right]){
            cache[left][right] = isValid(charArr, left + 1, right - 1, cache);
        }else{
            cache[left][right] = -1;
        }
        return cache[left][right];
    }
}
