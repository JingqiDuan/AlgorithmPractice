class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return new String();
        }
        Stack<Integer> counter = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int index = 0;
        String resultStr = "";
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                counter.push(count);
            }else if(s.charAt(index) == '['){
                strStack.push(resultStr);
                resultStr = "";
                index++;
            }else if(s.charAt(index) == ']'){
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int repetition = counter.pop();
                for(int i = 0; i < repetition; i++){
                    tmp.append(resultStr);
                }
                resultStr = tmp.toString();
                index++;
            }else{
                resultStr += s.charAt(index);
                index++;
            }
        }
        return resultStr;
    }
}
