class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int result = Integer.MAX_VALUE, steps = 0, cur = startIndex;
        while(steps < n){
            cur = (startIndex + steps) % n; 
            if(words[cur].equals(target)){
                result = steps;
                break;
            }
            steps++;
        }
        steps = 0;
        while(steps < n){
            cur = (startIndex - steps + n) % n;
            if(words[cur].equals(target)){
                result = Math.min(result, steps);
                break;
            }
            steps++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
