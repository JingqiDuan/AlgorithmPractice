class Solution {
    public int magicalString(int n) {
        int count = 3, index = 2, ans = 1;
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        list.add(1);
        list.add(2);
        list.add(2);
        while(count < n){
            int tmp = list.get(index++);
            for(int i = 0; i < tmp; i++){
                int num = flag ? 1 : 2;
                list.add(num);
                ans += flag ? 1 : 0;
                count++;
                if(count >= n) break;
            }
            flag = !flag;
        }
        return ans;
    }
}
