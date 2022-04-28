/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    //(randX() - 1)*Y + randY() 可以等概率的生成[1, X * Y]范围的随机数
    public int rand10() {
        int num = rand7() + (rand7() - 1) * 7;
        while(num > 40){
            num = rand7() + (rand7() - 1) * 7;
        }
        // +1 is in case num = 40 will get 0
        return 1 + num % 10;
    }
}

/*
  class Solution extends SolBase {
    //(randX() - 1)*Y + randY() 可以等概率的生成[1, X * Y]范围的随机数
    public int rand10() {
        int num = rand7() + (rand7() - 1) * 7;
        while(num > 10){
            num = rand7() + (rand7() - 1) * 7;
        }
        return num;
    }
}
*/
