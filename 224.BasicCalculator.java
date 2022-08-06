class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        stack.push(sign);
        int index = 0;
        int len = s.length();
        int result = 0;
        while(index < len){
            char ch = s.charAt(index);
            if(ch == ' '){
                index++;
            }else if(ch == '('){
                stack.push(sign);
                index++;
            }else if(ch == '+'){
                sign = stack.peek();
                index++;
            }else if(ch == '-'){
                sign = -stack.peek();
                index++;
            }else if(ch == ')'){
                stack.pop();
                index++;
            }else{
                int num = 0;
                while(index < len && Character.isDigit(s.charAt(index))){
                    num = num * 10 + s.charAt(index++) - '0';
                }
                result += sign * num;
            }
        }
        return result;
    }
}
