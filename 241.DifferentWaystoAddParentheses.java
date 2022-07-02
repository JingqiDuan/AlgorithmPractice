class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        for(start = 0; start < expression.length(); start++){
            char ch = expression.charAt(start);
            if(!Character.isDigit(ch)){
                break;
            }
        }
        if(start == expression.length()){
            result.add(Integer.parseInt(expression));
        }
        for(int i = start; i < expression.length(); i++){
            char operator = expression.charAt(i);
            if(Character.isDigit(operator)){
                continue;
            }
            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
            for(int l : left){
                for(int r: right){
                    if(operator == '+'){
                        result.add(l + r);
                    }else if(operator == '-'){
                        result.add(l - r);
                    }else if(operator == '*'){
                        result.add(l * r);
                    }
                }
            }
        }
        return result;
    }
}
