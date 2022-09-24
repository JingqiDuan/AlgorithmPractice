class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        if(k == 0) return new int[len];
        int[] result = new int[len];
        for(int i = 0; i < len; i++){
            int tmp = 0;
            for(int j = 1; j <= Math.abs(k); j++){
                int index = k > 0 ? (i + j) % len : (len + i - j) % len;
                result[i] += code[index];
            }
        }
        return result;
    }
}
