class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> deque = new LinkedList<>();
        //12a345 > 12b345 -> a > b
        //check left number and delete
        for(char c : num.toCharArray()){
            while(k > 0 && !deque.isEmpty() && deque.peekLast() > c - '0'){
                deque.pollLast();
                k--;
            }
            deque.offerLast(c - '0');
        }
        //in case the last one is big number
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        StringBuilder result = new StringBuilder();
        boolean startWithZero = true;
        while(!deque.isEmpty()){
            if(deque.peekFirst() == 0 && startWithZero){
                deque.pollFirst();
                continue;
            }
            startWithZero = false;
            result.append(deque.pollFirst());
        }
        
        return result.length() == 0 ? "0" : result.toString();
    }
}
