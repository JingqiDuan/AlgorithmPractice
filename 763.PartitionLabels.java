class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastPos = new int[26];
        for(int i = 0; i < s.length(); i++){
            lastPos[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = lastPos[s.charAt(0) - 'a'];
        while(start < s.length()){
            for(int i = start; i <= end; i++){
                end = Math.max(end, lastPos[s.charAt(i) - 'a']);
            }
            result.add(end - start + 1);
            start = end + 1;
            end++;
        }
        return result;
    }
}
