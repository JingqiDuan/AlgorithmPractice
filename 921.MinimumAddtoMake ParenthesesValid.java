class Solution {
    public int minAddToMakeValid(String s) {
        int score = 0, result = 0;
        for(char c : s.toCharArray()){
            score += c == '(' ? 1 : -1;
            if(score < 0){
                score = 0;
                result += 1;
            }
        }
        return score + result;
    }
}
