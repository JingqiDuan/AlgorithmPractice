class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while(n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        long number = start + (n - 1) / digit;
        String str = Long.toString(number);
        return str.charAt((n - 1) % digit) - '0';
    }
}
