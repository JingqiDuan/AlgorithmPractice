class Solution {
    private int minCount = 21;
    public int kSimilarity(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        
        return helper(s1.toCharArray(), s2.toCharArray(), 0, 0);
    }

    public int helper(char[] s1, char[] s2, int index, int count){
        if(count >= minCount) return minCount;
        if(index == s1.length - 1) return minCount = Math.min(minCount, count);
        for(int i = index; i < s1.length; i++){
            if(s1[i] != s2[i]){
                for(int j = i + 1; j < s2.length; j++){
                    if(s2[j] == s1[i] && s2[j] != s1[j]){
                        swap(s2, i, j);
                        helper(s1, s2, i + 1, count + 1);//why?
                        swap(s2, i, j);
                        if (s2[i] == s1[j]) break;
                    }
                }
                return minCount;
            }
        }
        return minCount = Math.min(minCount, count);
    }

    public void swap(char[] arr, int left, int right){
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
