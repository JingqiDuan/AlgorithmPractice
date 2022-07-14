class Solution {
    int result = 0;

    public int maxLength(List<String> arr) {
        ArrayList<Integer> masks = new ArrayList<>();
        for(String str : arr){
            int mask = 0;
            for(char ch : str.toCharArray()){
                int index = ch - 'a';
                if(((mask >> index) & 1) != 0){
                    mask = 0;
                    break;
                }
                mask |= 1 << index;
            }
            if(mask != 0){
                masks.add(mask);
            }
        }
        helper(masks, 0, 0);
        return result;
    }

    public void helper(ArrayList<Integer> masks, int pos, int mask){
        if(pos == masks.size()){
            result = Math.max(result, Integer.bitCount(mask));
            return;
        }
        if((mask & masks.get(pos)) == 0){
            helper(masks, pos + 1, mask | masks.get(pos));
        }
        helper(masks, pos + 1, mask);
    }
}
