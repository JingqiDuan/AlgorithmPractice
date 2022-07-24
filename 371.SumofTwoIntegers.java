class Solution {
    public int getSum(int a, int b) {
       // & the place where carry is found
       // << 1 move the carry leftward for 1 place
       // ^ do the actuall add
       //add carry
       while(b != 0){
           int carry = (a & b) << 1;
           a = a ^ b;
           b = carry;
       }
       return a;
    }
}
