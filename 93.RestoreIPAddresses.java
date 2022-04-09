class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12){
            return results;
        }
        Stack<String> path = new Stack<>();
        helper(s, 0, 0, path, results);
        return results;
    }

    public void helper(String s, int start, int depth, Stack<String> path, List<String> results){
        if(start == s.length()){
            if(depth == 4){
                results.add(String.join(".", path));
            }
            return;
        }
        
        for(int i = start; i < start + 3; i++){
            if(i >= s.length()){
                break;
            }
            if((4 - depth) * 3 < s.length() - i){
                continue;
            }
            if(isValid(s, start, i)){
                String newFrag = s.substring(start, i + 1);
                path.push(newFrag);
                helper(s, i + 1, depth + 1, path, results);
                path.pop();
            }
        }
    }

    public boolean isValid(String s, int left, int right){
        int len = right - left + 1;
        if(len > 1 && s.charAt(left) == '0'){
            return false;
        }
        int num = 0;
        for(int i = left; i <= right; i++){
            num = num * 10 + (s.charAt(i) - '0');
        }
        return num >= 0 && num <= 255;
    }
}
