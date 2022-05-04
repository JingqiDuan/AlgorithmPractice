class Solution {
    public void reverseWords(char[] s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s){
            sb.append(ch);
        }
        String str = sb.toString();
        int len = s.length;
        int left = len - 1;
        int right = len - 1;
        int index = 0;
        while(left >=0 && right >= 0){
            while(left >=0 && str.charAt(left) != ' '){
                left--;
            }
            String word = str.substring(left + 1, right + 1);
            left--;
            right = left;
            for(char ch : word.toCharArray()){
                s[index++] = ch;
            }
            if(index < len - 1) s[index++] = ' ';
        }
    }
}
