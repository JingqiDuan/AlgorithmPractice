class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return results;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
      
        StringBuilder letterComb = new StringBuilder();
        helper(digits, map, 0, letterComb, results);
        return results;
    }

    private void helper(String digits, Map<Character, String> map, int index, 
                        StringBuilder letterComb, List<String> results){
        if(digits.length() == index){
            results.add(new String(letterComb.toString()));
        }else{
            //letters from each digit combine with digits from other numbers
            char digit = digits.charAt(index);
            String lettersOfNumber = map.get(digit);
            for(int i = 0; i < lettersOfNumber.length(); i++){
                letterComb = letterComb.append(lettersOfNumber.charAt(i));
                helper(digits, map, index + 1, letterComb ,results);
                letterComb.deleteCharAt(index);
            }
        }
    }
}
