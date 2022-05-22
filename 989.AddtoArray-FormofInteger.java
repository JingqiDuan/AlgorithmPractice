class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int index = num.length - 1;
        int carry = 0;
        int sum = 0;
        while(index >= 0 || k > 0 || carry != 0){
            int a = index >= 0 ? num[index--] : 0;
            //last digit of k
            int b = k == 0 ? 0 : k % 10;
            sum = a + b + carry;
            int digit = sum % 10;
            carry = sum / 10;
            k /= 10;
            result.add(0, digit);
        }
        return result;
    }
}
