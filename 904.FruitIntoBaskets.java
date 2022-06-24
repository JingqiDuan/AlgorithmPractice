class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int result = 0;
        int leftF = fruits[left];
        int rightF = fruits[right];
        while(right < fruits.length){
            if(fruits[right] == rightF || fruits[right] == leftF){
                result = Math.max(result, right - left + 1);
                right++;
            }else{
                left = right - 1;
                leftF = fruits[left];
                while(left >= 1 && fruits[left - 1] == leftF){
                    left--;
                }
                rightF = fruits[right];
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}
