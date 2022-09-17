class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] counter = new int[26];
        int result = -1;
        Arrays.fill(counter, 301);
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            int index = arr[i] - 'a';
            counter[index] = Math.min(counter[index], i);
            result = Math.max(result, i - counter[index] - 1);
        }
        return result;
    }
}
