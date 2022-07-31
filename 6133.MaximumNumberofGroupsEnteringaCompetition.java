class Solution {
    public int maximumGroups(int[] grades) {
        if(grades.length == 1){
            return 1;
        }
        int len = grades.length;
        int cur = 2;
        int index = 1;
        while(index < len){
            for(int i = 0; i < cur && index <= len; i++){
                index++;
            }
            if(index > len){
                break;
            }
            cur++;
        }
        return cur - 1;
    }
}
