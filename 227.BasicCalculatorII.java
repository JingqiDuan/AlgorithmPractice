class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                if(preSign == '+'){
                    stack.push(num);
                }else if(preSign == '-'){
                    stack.push(-num);
                }else if(preSign == '*'){
                    stack.push(stack.pop() * num);
                }else{
                    stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
