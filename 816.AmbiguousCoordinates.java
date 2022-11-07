class Solution {
    private String s;
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        this.s = s.substring(1, s.length() - 1);
        int n = this.s.length();
        for(int i = 0; i < n - 1; i++){ // add , after index i
            List<String> left = helper(0, i), right = helper(i + 1, n - 1);
            for(String a : left){
                for(String b : right){
                    result.add("(" + a + ", " + b +")");
                }
            }
        }
        return result;
    }
    public List<String> helper(int start, int end){
        List<String> ans = new ArrayList<>();
        //when partition is only one digit
        if(start == end || s.charAt(start) != '0') ans.add(s.substring(start, end + 1));
        for(int i = start; i < end; i++){
            String left = s.substring(start, i + 1), right = s.substring(i + 1, end + 1);
            if(left.length() > 1 && left.charAt(0) == '0') continue;
            if(right.charAt(right.length() - 1) == '0') continue;
            ans.add(left + "." + right);
        }
        return ans;
    }
}
