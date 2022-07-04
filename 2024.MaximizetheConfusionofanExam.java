class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int len = answerKey.length();
        int result = 0;
        int flip = 0;
        int right = 0;
        for(int i = 0; i < len; i++){
            while(right < len && (answerKey.charAt(right) == 'T' || flip < k)){
                if(answerKey.charAt(right) == 'F'){
                    flip++;
                }
                right++;
            }
            result = Math.max(result, right - i);
            if(answerKey.charAt(i) == 'F'){
                flip--;
            }
        }

        right = 0;
        flip = 0;
        for(int i = 0; i < len; i++){
            while(right < len && (answerKey.charAt(right) == 'F' || flip < k)){
                if(answerKey.charAt(right) == 'T'){
                    flip++;
                }
                right++;
            }
            result = Math.max(result, right - i);
            if(answerKey.charAt(i) == 'T'){
                flip--;
            }
        }
        return result;
    }
}
