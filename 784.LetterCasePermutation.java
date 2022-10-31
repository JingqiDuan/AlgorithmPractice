class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s.toCharArray(), 0, result);
        return result;
    }
    public void helper(char[] arr, int index, List<String> result){
        if(index == arr.length){
            result.add(new String(arr));
            return;
        }
        helper(arr, index + 1, result);
        if(Character.isLetter(arr[index])){
            arr[index] ^= 1 << 5;
            helper(arr, index + 1, result);
        }
    }
}
