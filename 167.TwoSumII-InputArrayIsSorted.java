class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            while(left < right && numbers[left] < target - numbers[right]){
                left++;
            }
            while(left < right && numbers[left] > target - numbers[right]){
                right--;
            }
            if(numbers[left] == target - numbers[right]){
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
