class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if(n == 0){
            return result;
        }
        int total = (int)Math.pow(2, n);
        int index = 1;
        int addVal = 1;
        while(index < total){
            int size = result.size();
            while(size > 0){
                result.add(result.get(--size) + addVal);
                index++;
            }
            addVal *= 2;
        }
        return result;
    }
}
