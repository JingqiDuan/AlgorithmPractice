class Solution {
    public int compress(char[] chars) {
        if(chars == null || chars.length == 0){
            return 0;
        }
        int len = chars.length;
        int left = 0;
        int right = 0;
        while(right < len){
            int index = right;
            while(right < len && chars[right] == chars[index]){
                right++;
            }
            chars[left] = chars[right - 1];
            int reps = right - index;
            if(reps == 1){
                left++;
            }else if(reps <= 9){
                chars[++left] = (char) (reps + '0');
                left++;
            }else{
                String tmp = String.valueOf(reps);
                for(int i = 0; i < tmp.length(); i++){
                    chars[++left] = tmp.charAt(i);
                }
                left++;
            }
        }
        return left;
    }
}
