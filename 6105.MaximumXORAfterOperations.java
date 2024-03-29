class Solution {
    public int maximumXOR(int[] nums) {
         /*
        每次操作都能选择任意的 x，那么 nums[i] XOR x 的结果就是任意值。把 nums[i] 改写成二进制表示，通过与任意值的按位与运算，我们能保留二进制表示中任意数量的 1。
        因此我们枚举所有二进制位，随便选择数组中该位是 1 的一个数，保留这个 1，并把其它数的这一位都变成 0，即可让最终的异或和中这一位是 1。
        也就是说，对于所有二进制位，只要这一位在数组中出现过 1，那么答案里这一位也是 1。因此答案就是所有数按位或的结果。复杂度 \mathcal{O}(n)O(n)。
         */
        int result = 0;
        for(int num : nums){
            result |= num;
        }
        return result;
    }
}
