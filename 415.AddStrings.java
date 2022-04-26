class Solution {
    public String addStrings(String num1, String num2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(char c : num1.toCharArray()){
            stack1.push(c - '0');
        }
        for(char c : num2.toCharArray()){
            stack2.push(c - '0');
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = a + b + carry;
            int num = sum % 10;
            carry = sum / 10;
            sb.append(num);
        }
        return sb.reverse().toString();
    }
}
